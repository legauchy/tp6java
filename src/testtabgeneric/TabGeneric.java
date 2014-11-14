package testtabgeneric;

class TabGeneric<E extends Comparable<? super E>> {

    private static final int DEFAULT=10;

    private E[] tab;

    private final int n;

    private int nbElt;

    TabGeneric(final int n) {
	this.n=n;
	tab=(E[])new Comparable[n];
	nbElt=0;
    }

    TabGeneric() {
	this(DEFAULT);
    }  

    public int size(){
	return nbElt;
    }
    
    public boolean empty(){
	return size()==0;
    }

    public E value(int i) {
	return tab[i];
    }

    private E[] copy(E[] t) {
	for(int i=0;i<size();i++) t[i]=value(i);
	return t;
    }

    private void grow() {
	tab=copy((E[])new Comparable[tab.length+n]);
    }

    public void add(E c) {
	if(size()==tab.length) grow();
	tab[nbElt++]=c;
    }
 
    public E remove() {
	return value(--nbElt);
    }

    public void modify(int i,E c) {
	tab[i]=c;
    }

    public void insert(int i,E c) {
	if(size()==tab.length) grow();
	for(int j=size();j>i;j--) tab[j]=value(j-1);
	tab[i]=c;
	nbElt++;
    }

    public E remove(int i) {
	E c=value(i);
	for(int j=i;j<size()-1;j++) tab[j]=value(j+1);
	nbElt--;
	return c;
    }

    private String toString(int i) {
	if (i>=size()) return "";
	if (i==size()-1) return value(i).toString();
	return value(i)+","+toString(i+1);
    }

    public String toString() {
	String s=null;
	s = "["+toString(0)+"]";
	return s;
    }

    public void heapsort(){
        for(int i = 1 ; i < this.nbElt ; i++) {
            this.monter(i);
        }
        int i = this.nbElt-1;
        while(i > 0) {
            this.echanger(0,i);
            i--;
            this.descendre(i);  
        }
    }
    
    /*
     * @pre_cond i >= 0 && i <= this.nbElt-1 && j >= 0 && j <= this.nbElt-1
     * @post_cond _this.tab[i] = this.tab[j] && _this.tab[j] == this.tab[i]
     */
    private void echanger(int i, int j) {
        E tmp;
        tmp = this.value(i);
        this.modify(i, this.value(j));
        this.modify(j, tmp);
    }
    
    /*
     * @pre_cond j >= 0 && j <= this.nbElt-1
     * @post_cond tab[j] <= tab[j/2] && tab[j] > tab[2*j] && tab[j] > tab[2*j + 1]
     */
    private void monter(int j) {
        while (this.value(j).compareTo(this.value(j/2)) > 0) {
            this.echanger(j, j/2);
            j = j/2;
        }
    }
    
    /*
     * @pre_cond j >= 0 && j <= this.nbElt-1
     * @post_cond 
     */
    private void descendre(int j){
        int i = 0;
        if(i*2 < j)
            
        while( i*2 < j && (this.value(i).compareTo(this.value(i*2)) < 0 || this.value(i).compareTo(this.value(i*2+1)) < 0) ) {
            if (this.value(i*2).compareTo(this.value(i*2+1)) > 0) {
                this.echanger(i, i*2);
                i = i*2;
            } else {
                this.echanger(i, i*2+1);
                i = i*2+1;
            }
        }
    }

}
