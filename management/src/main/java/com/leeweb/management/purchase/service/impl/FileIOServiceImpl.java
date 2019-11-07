package com.leeweb.management.purchase.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeweb.management.Properties;
import com.leeweb.management.purchase.dao.FileIODao;
import com.leeweb.management.purchase.dto.FileDTO;
import com.leeweb.management.purchase.service.FileIOService;

@Service
public class FileIOServiceImpl implements  FileIOService{

	Logger logger = LoggerFactory.getLogger(FileIOServiceImpl.class);

	@Autowired
	FileIODao fileIODao;

	/**
	 * @author イーソンハク
	 * @param String filePath
	 * @return String msg
	 * @exception FileNotFoundException、IndexOutOfBoundsException、NumberFormatException、IOException、NullPointerException
	 */
	@Override
	public String insertFile(String filePath) {

		System.out.println(Properties.SORTING_LINE);
		logger.info("File Input Serviceを実行します。");

		String msg = "";
		Properties.ORIGINAL_FILEPATH = filePath;

		System.out.println("Upload File Path : " + Properties.ORIGINAL_FILEPATH );

		//List to save the contents of readFile
		List<FileDTO> readDataList = new ArrayList<>();
		Map<String, String> map = new HashMap<>();

		//File read
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(Properties.ORIGINAL_FILEPATH);

			br = new BufferedReader(fr);

			Charset.forName(Properties.UNICODE);

			String dataLine;

			//Save splitted lines by separator
			String[] splittedData;

			//Check Category In File
			List<String> checkCategory = new ArrayList<>();

			//Check the first line
			boolean b_FirstLine = true;

			while((dataLine = br.readLine()) != null) {
				FileDTO fileDTO = new FileDTO();

				if(b_FirstLine == true) {
					splittedData = dataLine.split(Properties.SEPARATOR_DATA);
					for(int i = 0; i < splittedData.length; i++) {
						checkCategory.add(splittedData[i]);
					}

					//Check Category size
					if(checkCategory.size() != Properties.UPLOADFILE_CATEGORY.length) {
						logger.debug("Unable to save the contents of the file to DB");
						System.out.println(Properties.SORTING_LINE);
						msg = "Unable to save the contents of the file to DB";
						return msg;
					}
					else {
						//Check Category contents
						for(int i = 0; i < checkCategory.size(); i ++) {
							if(!checkCategory.get(i).contains(Properties.UPLOADFILE_CATEGORY[i])) {
								logger.debug("Unable to save the contents of the file to DB");
								System.out.println(Properties.SORTING_LINE);
								msg = "Unable to save the contents of the file to DB";
								return msg;
							}
						}
					}

					b_FirstLine = false;
				}

				else {
					splittedData = dataLine.split(Properties.SEPARATOR_DATA);
					for(int i = 0; i < splittedData.length; i++) {

						//key : items in Category value : contents in splitedData
						map.put(Properties.UPLOADFILE_CATEGORY[i], splittedData[i]);
					}

					fileDTO.setPRODUCT_ID(map.get(Properties.UPLOADFILE_CATEGORY[0]));

					//Check whether Type Conversion possible or impossible
					if(Integer.class.isInstance(Integer.parseInt(map.get(Properties.UPLOADFILE_CATEGORY[1])))) {
						fileDTO.setQUANTITY(Integer.parseInt(map.get(Properties.UPLOADFILE_CATEGORY[1])));
					}
					fileDTO.setCREATE_USER(Properties.USERCODE);
					fileDTO.setUPDATE_USER(Properties.USERCODE);
					readDataList.add(fileDTO);
				}
			}
		} catch (FileNotFoundException fn) {
			logger.debug(fn + "エラーが発生しました。");
			System.out.println(Properties.SORTING_LINE);
			msg = "FileNotFoundException";
			return msg;
		} catch (IndexOutOfBoundsException io) {
			logger.debug(io + "エラーが発生しました。");
			System.out.println(Properties.SORTING_LINE);
			msg = "IndexOutOfBoundsException";
			return msg;
		} catch (NumberFormatException n) {
			logger.debug(n + "エラーが発生しました。");
			System.out.println(Properties.SORTING_LINE);
			msg = "NumberFormatException";
			return msg;
		} catch (IOException e) {
			logger.debug(e + "エラーが発生しました。");
			System.out.println(Properties.SORTING_LINE);
			msg = "IOException";
			return msg;
		} catch(NullPointerException n) {
			logger.debug(n + "エラーが発生しました。");
			System.out.println(Properties.SORTING_LINE);
			msg = "NullPointerException";
			return msg;
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
			}
			catch(IOException e) {
				logger.debug(e + "エラーが発生しました。");
				System.out.println(Properties.SORTING_LINE);
				msg = "IOException";
				return msg;
			}
			finally {
				br = null;
			}
		}
		fileIODao.insertFile(readDataList);

		logger.info("File Input Serviceを終わります。");
		System.out.println(Properties.SORTING_LINE);
		return msg;
	}
}
