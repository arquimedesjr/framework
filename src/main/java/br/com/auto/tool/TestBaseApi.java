package br.com.auto.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.tool.interfaces.Api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBaseApi implements Api {

	private Logger logger = Logger.getLogger(TestBaseApi.class);
	private RequestSpecification httpRequest;
	public String getJson;
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

	public String get() {
//		RequestSpecification request = request(serviceName);
		httpRequest.header("Content-Type", "application/json");
//		httpRequest.header("token", "ZVtrRXcpTnYWpsjnIpS3olQFGek84E5Z");
		Response response = httpRequest.get();
		getJson = response.prettyPrint();
		System.out.println(getJson);
		Reporter.addStepLog("<span style=\"color: #0077b3;\">" + getJson + "<br></span>");
		code = response.getStatusCode();
		System.out.println(code);
		return getJson;
	}

	public void delete() {
		String json = get();
		logger.info("Realizando um DELETE atraves do json:\n " + json);
//		Reporter.addStepLog("<span style=\"color: #0077b3;\">" + json + "<br></span>");
		Response response = httpRequest.delete(RestAssured.baseURI);
		code = response.getStatusCode();
	}

	public void update(String pathJson) {
		logger.info("Realizando um PUT atraves do json:\n " + pathJson);
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
		Response response = httpRequest.put(RestAssured.baseURI);

		Reporter.addStepLog("<span style=\"color: #0077b3;\">" + jsonTxt + "<br></span>");

		code = response.getStatusCode();

	}

	public void validacion(String key, String value) {
//		Reporter.addStepLog("<span style=\"color: #0077b3;\">| Parametro: " + key + "| Valor: " + value + "|<br></span>");
		StringBuilder json = new StringBuilder(getJson);
		System.out.println("Estou aqui: " + json);
		JSONObject obj = new JSONObject(getJson);
		System.out.println("Json: " + obj);

		if (!obj.get(key).equals(value))
			Assert.assertFalse("Não foi encontrado o valor " + value + " no key: " + key, true);

	}


}
