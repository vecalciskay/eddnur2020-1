package archivo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;

import archivo.ArchivoTexto;
import lista.Lista;

public class TestLectura {
	public static void main(String[] args) {

		String pathrchivo = "e:\\temp\\notas.txt";
		
		ArchivoTexto archivoTexto = new ArchivoTexto();
		File f = new File(pathrchivo);
		try {
			archivoTexto.leer(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(archivoTexto.getTexto());
//		
//		try {
//			List<String> lineas = Files.readAllLines(Paths.get(pathrchivo));
//			
//			for(String l : lineas)
//				System.out.println(l);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			archivoTexto.escribir("e:\\temp\\notas2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
