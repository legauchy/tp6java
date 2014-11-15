package testtabgeneric;

class CoupleGeneric<T extends Comparable<? super T>, U extends Comparable<? super U>> implements Comparable<CoupleGeneric<T, U>>{

    private T a;
    private U b;
    
    CoupleGeneric(T a, U b){
	this.a=a;
	this.b=b;
    }

    CoupleGeneric(CoupleGeneric<T, U> c) {
	this.a=c.getA();
	this.b=c.getB();
    }
    
    public T getA() {
        return this.a;
    }
    
    public U getB() {
        return this.b;
    }
    
    public boolean lt(CoupleGeneric<T, U> c) {
	return a.compareTo(c.a) < 0 || (a.compareTo(c.a) == 0 && b.compareTo(c.b) < 0);
    }

    public boolean eq(CoupleGeneric c) {
	return !(lt(c) || c.lt(this));
    }

    public boolean neq(CoupleGeneric c) {
	return !eq(c);
    }

    public boolean leq(CoupleGeneric c) {
	return eq(c) || lt(c);
    }

    public boolean gt(CoupleGeneric c) {
	return !leq(c);
    }

    public boolean geq(CoupleGeneric c) {
	return eq(c) || gt(c);
    }
   
    public String toString(){
	return "("+a+","+b+")";
    }

    @Override
    public int compareTo(CoupleGeneric o) {
        if(this.eq(o)) {
            return 0;
        }else if (this.gt(o)) {
            return 1;
        }else {
            return -1;
        }
    }
}
