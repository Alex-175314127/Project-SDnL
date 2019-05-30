/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwn;

/**
 *
 * @author Alexander Adam
 * @param <E>
 */
public class Tree<E> {
    
    private TreeNode<E> root; //root dari Tree
    private TreeNode<E> node; //arah tree
    
    
    /**
     * konstruktor kosong
     */
    public Tree() {
	root = new TreeNode<E>();
    }
    
    
    /**
     * Membuat Tree dengan data yang disimpan di root.
     * @param data - data yang akan ditambahkan di root tree
     * @throws IllegalArgumentException
     */
    public Tree(E data) throws IllegalArgumentException{
    
    if(data == null){
    	throw new IllegalArgumentException("null data");
    }
    else{
		root = new TreeNode<E>(data);
	}
    }
    
    
    /**
     * Mulai referensi saat ini di root untuk memulai navigasi
     * dari tree
     */
    public void mulai() {
	node = root;
    }
    
    /**
     * Mengembalikan data yang disimpan dalam node saat ini 
     * Error jika tidak ada simpul saat ini dalam navigasi.
     * @throws Error
     */
    public E getCurrent() throws Error {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null) {
	    throw new Error("node tidak didefinisikan");
	}
	
	// return data ke node saat ini:
	else {
	    return node.getData();
	}
    }
    
    
    /**
     * Memindahkan referensi saat ini ke left child dari node saat ini di
     * Error jika node saat ini tidak memiliki child yang tepat.
     * @throws Error
     */
    public void goLeft() throws Error {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null) {
	    throw new Error("node tidak di definisikan");
	}
	
	// memeriksa apakah ada child yang tersisa:
	if (node.getLeft() == null) {
	    throw new Error("left child tidak tersedia");
	}
	
	// pindahkan node saat ini ke left child:
	else {
	    node = node.getLeft();
	}
    }
    
    
    /**
     * Memindahkan referensi saat ini ke right Child dari simpul saat ini
     * throw Error jika node saat ini tidak memiliki child yang tepat.
     * @throws Error
     */
    public void goRight() throws Error {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null ) {
	    throw new Error("node tidak di definisikan");
	}
	
	// memeriksa apakah child ada:
	if (node.getRight() == null) {
	    throw new Error("right child tidak ada");
	}
	
	// pindahkan referensi node saat ini ke right child :
	else {
	    node = node.getRight();
	}
    }
    
    
    /**
     * Mengembalikan nilai true jika node saat ini  adalah leaf 
     */
    public boolean isLeaf() throws Error {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null ) {
	    throw new Error("node tidak di definisikan");
	}
	
	// Kembalikan benar jika tidak ada left child atau right child:
	if (node.getRight() == null && node.getRight() == null) {
	    return true;
	}
	
	// Return false jika node memiliki child:
	else {
	    return false;
	}
    }
    
    
    /**
     * Mengubah data yang dimiliki oleh node saat ini ke yang ditentukan
     * data.
     * @param data - data untuk dimasukkan ke dalam simpul saat ini.
     * @throws Error IllegalArgumentException
     */
    public void newData(E data) throws Error,
    IllegalArgumentException {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null) {
	    throw new Error("node tidak didefinisikan");
	}
	
	// set data ke node:
	else {
		if(data == null){
			throw new IllegalArgumentException("null data");
		}
		else{
	    	node.setData(data);
	    }
	}
    }
    
    
    /**
     * Menambahkan node dengan child yang ditentukan sebagai child yang tepat saat ini
     * throw IllegalBinaryTreeOpException 
     * jika node saat ini sudah memiliki anak yang tepat.     
     * @param data - the data to add as the specified child.
     * @throws Error IllegalArgumentException 
     */
    public void addRightChild(E data) throws Error,
    IllegalArgumentException {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null) {
	    throw new Error("current node not defined");
	}
	
	// periksa apakah child yang tepat belum didefinisikan:
	if (node.getRight() != null) {
	    throw new Error("right child defined");
	}
	
	// tambahkan data ke node right child:
	else {
		if(data == null){
			throw new IllegalArgumentException("null data");
		}
		else{
	    	node.setRight(data);
	    }
	}
    }
    
    
    /**
     * Menambahkan node dengan child yang ditentukan sebagai left child saat ini
     * throw IllegalBinaryTreeOpException
     * jika simpul saat ini sudah memiliki left child.
     * @param data - data untuk ditambahkan dengan child yang ditentukan
     * @throws Error IllegalArgumentException
     */
     public void addLeftChild(E data) throws Error,
     IllegalArgumentException {
	
	// periksa apakah node saat ini didefinisikan:
	if (node == null) { 
	    throw new Error("node saat ini tidak di definisikan");
	}
	
	// periksa bahwa anak kiri belum didefinisikan:
	if (node.getLeft() != null) {
	    throw new Error("left child tidak di definisiakan");
	} 
	
	// tambahkan data ke node left child:
	else {
		if(data == null){
			throw new IllegalArgumentException("null data");
		}
		else{
	    	node.setLeft(data);
	    }
	}
    }
    
    
    /**
     * Pre-order mencetak pohon, mulai dari root. Setiap level tambahan
      * Pohon bertambah tiga ruang.
     */
    public void print() {
	
	// periksa root ada sebelum memanggil method cetak 
	if (root != null) {
	    this.print(root, 0);
	}
    }
    
    
    /**
     * Methode untuk print() untuk mencetak berulang
     * @param root - TreeNode yang sedang diproses
     * @param x - jarak
     */
    private void print(TreeNode<E> root, int x) {
	
	// implicit base case: check root exists.
	if (root != null) {
	    
	    // for first level, print indentation of zero:
	    if (x == 0) {
		System.out.println(root.getData());
	    }
	    
	    // for other levels, add print spacing:
	    else {
		System.out.printf("%"+x+"s"+root.getData()+"\n", "");
	    }
	    
	    // recursive calls to print left and right child nodes:
	    // space increase by 3 to create the
	    print(root.getLeft(), x+3);
	    print(root.getRight(), x+3);
	}
    }
    
}
