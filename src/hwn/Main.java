/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwn;

import static hwn.Data.checkOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Adam
 */
public class Main {
        /**
     * main class untuk memulai program
     * @param args - file input opsional
     */
    private static Tree<String> root;
    public static void main(String[] args) {

	root = null;//tree menyimpan pertanyaan dan jawaban
	File dataFile;//file dengan data untuk diimpor
	String command;//variabel yang berfungsi untuk input
	
	// format yang tidak benar
	if (args.length > 1) {
	    System.out.println("Java testTree");
	    System.exit(0);
	}
	
	// Baca file input yang disediakan:
	else if (args.length == 1) {
	    
	    // load file dan cetak pesan jika tidak ada:
	    dataFile = new File(args[0]);
	    if (!dataFile.exists()) {
		System.out.println("File tidak di temukan");
	    }
	    
	    // load file dan cetak pesan jika ada:
	    else {
		boolean doneLoading = false;
		try {
		    Scanner sc = new Scanner(dataFile);
		    
		    while (sc.hasNext() && !doneLoading) {
			System.out.println("Masukan perintah t(Tree) p(mulai) q(keluar) r(reset): ");
			command = sc.nextLine();
			
			// memanggil method yang memeriksa opsi perintah:
			try {
                            try {
                                doneLoading = checkOptions(sc, command);
                            } catch (Error ex) {
                                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                            }
			} catch (IllegalArgumentException iae) {
			    // 
			}                       
		    }
		    sc.close();
		}		
		// Jika file input tidak ditemukan, cetak pesan
		catch (FileNotFoundException fnfe) {
		    System.out.println("File tidak di temukan");
		}		
	    }
	} //selesai membaca file input
	
	
	// Terima input 
	boolean donePlaying = false;
	Scanner userInput = new Scanner(System.in);
	while (!donePlaying) {
	    
	    // pengguna prompt untuk perintah:
	    System.out.print("Masukan perintah t(Tree) p(mulai) q(keluar) r(reset): ");
	    command = userInput.nextLine();
	    
	    // memanggil methdo yang memeriksa opsi perintah
	    try {
                try {
                    donePlaying = checkOptions(userInput, command);
                } catch (Error ex) {
                    Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }catch (IllegalArgumentException iae) {		
	    }                     	    
	}
	userInput.close(); //exit
    }
}
