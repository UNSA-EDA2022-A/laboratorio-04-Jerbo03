package com.example.project;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    import java. util. HashMap;
    public void deleteDuplicates() {
        if (isEmpty() || size == 1) return;
        else {
	    HashMap<T, Integer> dict = new HashMap<T, Integer>();
            Node<T> actual = first;
	    dict.put(first.getValue(),0);
            while (actual != null) { // Si el valor actual es null entonces ya terminamos de leer la lista
		if (dict.get(actual.getNext().getValue()) != null) {
			actual.setNext(actual.getNext().getNext());
			size--;
		} else {
			dict.put(actual.getNext().getValue(), 0);
			actual = actual.getNext();
		}
            }
        }
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
    	if (position > size) { // Si la posicion es mayor al tamano entonces no cambiar nada
    		System.out.println("Fuera de rango.");
    		return;}
    	if (position == 0) {
    		addFirst(data);
    		return;} // Si se quiere poner al comienzo, llamar a la funcion ya creada
    	Node<T> anterior = first; // Si la posicion es mayor a 0, empezar por el primer nodo
    	for (int i = 1; i < position; i++)
    		anterior = anterior.getNext(); // E ir cambiandolo hasta llegar al anterior al cual se desea insertar
    	Node<T> nuevo = new Node<T>(data, anterior.getNext()); // Crear el nodo dandole como next el nodo que ocupa su lugar
    	anterior.setNext(nuevo); // Y setearlo como next del anterior
	size++;
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
	if (position >= size) { // Si la posicion es mayor al tamano entonces no cambiar nada
    		System.out.println("Fuera de rango.");
    		return;}
	if (position == 0) {
    		removeFirst();
    		return;} // Si se quiere eliminar la primera, llamar a la funcion ya creada
	if (position == size-1) {
    		removeLast();
    		return;} // Si se quiere eliminar al final, llamar a la funcion ya creada
    	Node<T> anterior = first; // Si la posicion es valida, empezar por el primer nodo
    	for (int i = 1; i < position; i++)
    		anterior = anterior.getNext(); // E ir cambiandolo hasta llegar al anterior al cual se desea eliminar
    	anterior.setNext(anterior.getNext().getNext()); // Y setearlo como next del anterior
	size--;
    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}
