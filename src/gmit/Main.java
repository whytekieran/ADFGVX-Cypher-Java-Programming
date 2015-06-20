package gmit;

public class Main 
{
	public static void main(String[] args) 
	{
		ADFGVX cypher = new ADFGVX();
		
		cypher.loadEncryptValues();
		cypher.loadDecryptValues();
		cypher.getCodeAndFileName();
		cypher.determineArrayRows();
		
		long startTime = System.currentTimeMillis();
		
		cypher.readAndEncryptData();
		cypher.writeEncryptedFile();
		cypher.readEncryptedData();
		cypher.writeDecryptedData();
		
		System.out.println("Encrypt/Decrypt Complete");
		System.out.println("Running time (ms): " + (System.currentTimeMillis() - startTime));
	}
}
