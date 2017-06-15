class SingleLinkedList {
	private Node head;
	private int elementCount;

	SingleLinkedList() {
		head = null;
		elementCount = 0;
	}

	void addInFront(int data) {
		head = new Node(data, head);//head blir ny node som peker p� gamle head hvis den eksisterer.
		elementCount += 1;//�ker elementcount med 1.
	}// end addInFront

	void addEnd(int data) {
		Node pointer = head;//lager en "kopi" av head.
		if (pointer == null)//hvis listen er tom
			addInFront(data);
		else {
			while (pointer.next != null) {//s� lenge som pointer.next ikke er lik null
				pointer = pointer.next;//�k med pointer.next for hver gang
			}
			pointer.next = new Node(data, null);//n�r den n�r slutten lages det ny node som peker p� null.
			elementCount += 1;//�ker elementcount med 1.
		}
	}// end adEnd

	void deleteFront() {
		if (elementCount <= 1) {//hvis det er en element eller ingen
			head = null;//slettes hele listen
			elementCount = 0;//elementCount resetes.
		}
		if (elementCount > 1) {//dersom det er flere enn 1 element i listen
			head = head.next;//sletter f�rste head ved � sette den til head.next.
			elementCount--;//minker elementCount med 1.
		}
	}// end deleteFront

	void deleteEnd() {
		Node pointer = head;

		if (elementCount <= 1)//kall p� deleteFront() metoden dersom det er 1 eller f�rre elementer i listen.
			deleteFront();
		else {
			for (int i = 1; i < elementCount-1; i++)//g� fram til elementCount-1
				pointer = pointer.next;//�k med pointer.next
			pointer.next = null;//sett det siste verdi til null.
			elementCount--;//mink elementCount med 1.
		}
	}// end deleteEnd

	void deleteElement(int e) {// Sletter det f�rste elementet med oppgitt
									// verdi fra listen.
		Node pointer = head;
		if (pointer.element == e) {//dersom verdien er den f�rste i listen kall p� metoden deleteFront();
			deleteFront();
			
		}
		else {
			for (int i = 0; i <=elementCount; i++) {
				if (pointer.next.element == e)//g� s� lenge som pointer.next.elemet er lik verdien du vil slette
					break;//hopp ut av l�kka
				pointer = pointer.next;
			}
			if (pointer.next == null)
				return;
			else
				pointer.next = pointer.next.next;//"kobler" ut noden som skal slettes, ved at det pekes "over" den.
			elementCount--;
		}
	}// end deleteElement

	void deleteElements(int e) {// sletter alle elementene med oppgit verdi fra
								// listen.
		while(countElementsOfSpecificValue(e)!=0)//g� s� lenge som antall elementer med spesifikt verdi n�r null, da er alle elmenter av den vedien slettet
			deleteElement(e);
	}// end deleteElements

	void addElementAfter(int afterElement, int e) {
		Node pointer = head;
		if (pointer.element == afterElement) {
			pointer.next = new Node(e, pointer.next);
			elementCount++;
		} else {
			for (int i = 0; i <= elementCount; i++) {
				if (pointer.element == afterElement) {
					pointer.next = new Node(e, pointer.next);
					elementCount++;
					break;
				}
				pointer = pointer.next;
			}
		}

	}// end addElementAfter

	void addElementBefore(int beforeElement, int e) {
		Node pointer = head;
		Node newNode;
		if (head.element == beforeElement) {
			addInFront(e);
		} else {
			for (int i = 0; i < elementCount; i++) {
				if (pointer.next.element == beforeElement) {
					newNode = new Node(e, pointer.next);
					pointer.next = newNode;
					elementCount++;
					break;
				}
				pointer = pointer.next;
			}
		}

	}// end addElementBefore

	public String toString() {//
		Node pointer = head;
		String tekst = "";
		int counter = 0;
		if (pointer == null)
			tekst = ("NULL");
		else {
			while (pointer.next != null) {
				counter++;
				tekst += "("+pointer.element + ")-->";
				pointer = pointer.next;
				
			}
			tekst += "("+pointer.element + ")-->NULL ";
		}
		return tekst + "\n";
	}// end toString

	int countElementsOfSpecificValue(int e) {
		Node pointer = head;
		int counter = 0;
		if (elementCount == 0)
			deleteFront();
		else {
			for (int i = 1; i <= elementCount; i++) {
				if (pointer.element == e)
					counter++;
				pointer = pointer.next;
			}
		}
		return counter;
	}// end countElementsOfSpecificValue

	int getElementCount() {
		return elementCount;
	}

	public boolean isEmpty() {//sjekker om listen er tom, n�dvendig for feilmeldinger
		if (head == null)
			return true;
		else
			return false;
	}

	int deleteList() {//sletter hele listen ved � sette head=null og elementCount = 0, men f�rst gj�res et kopi av elementCount og den verdien retuneres. 
		head = null;
		int oldElementCount = elementCount;
		elementCount = 0;
		return oldElementCount;
	}

}// end class SingleLinkedList
