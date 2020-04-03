package br.com.auto.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.tool.interfaces.Api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBaseApi implements Api {

	private Logger logger = Logger.getLogger(TestBaseApi.class);
	private RequestSpecification httpRequest;
	public int code;

	public void setUp(String url) {
		logger.info("Acesso via API a url: " + url);
		Reporter.addStepLog("<span style=\"color: #0077b3;\">" + url + "<br></span>");
		RestAssured.baseURI = url;
		httpRequest = RestAssured.given();
	}

	public void post(String pathJson) {
		logger.info("Realizando um POST atraves do json:\n " + pathJson);
		httpRequest.header("Content-Type", "application/json");
		String jsonTxt = null;
		InputStream is;
		try {

			is = new FileInputStream(pathJson);
			jsonTxt = IOUtils.toString(is, "UTF-8");
			System.out.println(jsonTxt);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		httpRequest.body(jsonTxt);
		Response response = httpRequest.post(RestAssured.baseURI);

		Reporter.addStepLog("<span style=\"color: #0077b3;\">" + jsonTxt + "<br></span>");

		code = response.getStatusCode();

	}

	public void get() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public void update() {
		// TODO Auto-generated method stub

	}

}
