/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwn;

/**
 *
 * @author Alexander Adam
 */
import java.util.*;

/**
  * Kelas Main menggunakan class Tree untuk mewakili
  * dan menavigasi informasi yang digunakan untuk mengajukan pertanyaan dan membuat tebakan
  * Program meminta pengguna untuk berbagai perintah konsol, dan merespons
  * dengan tindakan yang sesuai. File input yang berisi sekumpulan perintah adalah
  * pilihan
 */
public class Data {
 
    private static Tree<String> root;
    
    
    /**
     * Method untuk mereset atau megosongkan tree
     * @param in
     * @throws Error IllegalArgumentException
     */
    //public static BinaryTree<String> reset(Scanner in) 
    public static void reset(Scanner in) 
	throws Error,
	IllegalArgumentException {
		
	// Create a new tree root using the question given by user:
	System.out.println("Masukan pertanyaan  : ");
	root = new Tree<String>(in.nextLine());
	root.mulai();//mulai navigasi tree dengan mengatur node saat ini ke root
	
	// jawaban yang benar akan masuk ke left Child
	System.out
	    .println("masukan jawaban yang benar :");
	root.addLeftChild(in.nextLine());
	
	// jawaban yang salah akan masuk ke right child
	System.out
	    .println("masukan jawaban yang salah : ");
	root.addRightChild(in.nextLine());
    }
    
    
    /**
     * memulai program sesuai input yang diberikan
     * @param in - akan menginput data dari scanner
     * @throws hwn.Error
     */
    
    public static void mulai(Scanner in) 
	throws Error, IllegalArgumentException {
	
	// mereset Tree
	String command;
	root.mulai();
	
	while (!root.isLeaf()) {
	    // cetak pertanyaan
	    System.out.println(root.getCurrent());
	    // user menginput jawaban y/n
	    command = in.nextLine().toLowerCase();
	    
	    if (command.equals("y") || command.equals("Y")) {
		root.goLeft();
	    }
	    else if (command.equals("n") || command.equals("N")) {
		root.goRight();
	    }
	    else {
		System.out.println("perintah salah");
	    }
	}
	
	// jawaban telah di simpan
	String oldGuess = root.getCurrent();
	System.out.println("maksud anda " + oldGuess + ". apa benar ?");
	
	command = in.nextLine().toLowerCase();
	
	if (command.equals("y") || command.equals("Y")) {
	    System.out.println("berhasil");
	}
	else if (command.equals("n") || command.equals("N")) {
	    // Ubah Node saat ini menjadi pertanyaan baru
	    System.out.println("Masukan pertanyaan yang sesuai untuk jawaban ini");
	    root.newData(in.nextLine());
	    
	    System.out.println("Jawaban :");
	    // set left child ke jawaban benar
	    root.addLeftChild(in.nextLine());
	    // Set right child ke jawaban salah
	    root.addRightChild(oldGuess);
	}
	else {
	    System.out.println("perintah salah");
	}
    }
    
    
    /**
     * Metode checkOptions mem-parsing input baik dari file atau konsol ke
     * menentukan tindakan yang harus diambil oleh program. Disebut oleh
     * Metode utama dan diterapkan untuk mengurangi redundansi kode
     * @param input - the Scanner used to input commands.
     * @param command - the current command to parse.
     * @returns true if the user chooses to quit, or if input file ends.
     * @throws IllegalBinaryTreeOpException.
     */
    public static boolean checkOptions(Scanner input, String command)
	throws Error {
	
	// true jika pengguna memilih untuk berhenti
	boolean result = false;
	
	// Jalankan perintah yang berbeda berdasarkan input dari file:
	switch (command) {
	    
	case "t" :// mengeluarkan Tree untuk dicetak ke output
	    if (root == null) {
		System.out.println("Tree Kosong");
	    }
	    else {
		root.print();
	    }
	    break;
	    
	case "p" :// mulai
	    if (root == null) {
		reset(input);
	    }
	   mulai(input);
	    break;
	    
	case "q" :// menghentikan program
	    result = true;
	    System.exit(0);
	    break;
	    
	case "r" :// reset Tree
	    reset(input);
	    break;
	    
	default:// jika perintah tidak di kenali
	    System.out.println("perintah Salah");
	    break;
	}
	
	return result;
    }      
}
