package com.leeweb.management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


//springbootの例外処理方法 - 1.ControllerAdvice : 全域処理 / 2.ExceptionHandler : コントローラー段での処理 / 3.try/catch : メソッド段での処理
@RestControllerAdvice		//コントローラーを補助するクラスに使うアノテーション。コントローラーで使われる共通機能をモジュール化して全域に使用します。
public class ManagementExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ManagementExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		logger.info("exception : " + e);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/5xx");
		return mv;
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleRuntimeException(RuntimeException e) {
		logger.info("exception : " + e);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/5xx");
		return mv;
	}
}