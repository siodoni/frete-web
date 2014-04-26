package br.com.snbsolucoes.util;

public class Anexo {
	
	private String filePath;
	private String fileName;
	private byte[] bytes;   
		
	public Anexo() {
		super();
	}	

	public Anexo(String fileName, byte[] bytes) {
		super();
		this.filePath = null;
		this.fileName = fileName;
		this.bytes = bytes;
	}
	
	public Anexo(String filePath) {
		super();
		this.filePath = filePath;
		this.fileName = null;
		this.bytes = null;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public byte[] getBytes() {
		return bytes;
	}			
}
