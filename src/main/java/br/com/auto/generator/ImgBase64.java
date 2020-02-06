package br.com.auto.generator;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import gherkin.deps.net.iharder.Base64;

public class ImgBase64 {
	private Logger logger = Logger.getLogger(ImgBase64.class);

	public String convertImgBase64(String path) {
		logger.info("Convertendo imagem para base64: "+path);
		String base64Image = null;

		try {

			BufferedImage bufferedImage = ImageIO.read(new File(path));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			base64Image = Base64.encodeBytes(imageInByte);

		} catch (Exception e) {
			logger.error("Erro ao converte imagem para base64:"+ e.getMessage());
		}
		return base64Image;
	}

	public String convertImgBase64Delete(String path) {
		logger.info("Convertendo imagem para base64 e depois deleta o arquivo: "+path);

		String base64Image = null;

		File file = new File(path);

		base64Image = convertImgBase64(file.getAbsolutePath());

		if (file.exists())
			file.deleteOnExit();

		return base64Image;
	}

}
