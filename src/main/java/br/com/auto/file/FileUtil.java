package br.com.auto.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileUtil {
	private Logger logger = Logger.getLogger(FileUtil.class);
	private File file;

	public boolean createrFile(String path, String archive) {
		logger.info("Criação do arquivo " + archive);
		boolean cond = false;

		file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		file = new File(path + File.separator + archive);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("Erro na Criação do Arquivo: " + e.getMessage());
			}
			cond = true;
		}

		return cond;
	}

	public List<String> reader(String path) throws IOException {
		logger.info("Lendo o arquivo no diretorio: " + path);
		List<String> linhas = new ArrayList<String>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				linhas.add(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();

		return linhas;
	}

	public void whiter(String path, List<String> linhas) {
		logger.info("Escrevendo o arquivo no diretorio: " + path);
		BufferedWriter buffWrite = null;
		BufferedReader buffRead = null;
		try {
			buffWrite = new BufferedWriter(new FileWriter(path));
			buffRead = new BufferedReader(new FileReader(path));
			String txtLinha = buffRead.readLine();

			for (String linha : linhas) {
				if (txtLinha == null) {
					buffWrite.append(linha + "\n");
				} else {
					buffWrite.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erro ao escrever o arquivo" + e.getMessage());

		} finally {
			try {
				buffRead.close();
				buffWrite.close();
			} catch (IOException e) {
				logger.error("Erro ao fechar o arquivo " + e.getMessage());
			}
		}

	}

	public void delete(String path) {
		logger.info("Excluindo o arquivo " + path);
		File file = new File(path);

		if (file.exists())
			file.delete();

	}

}
