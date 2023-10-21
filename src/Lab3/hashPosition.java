package Lab3;

class hashPosition<i,v> {
    i index;
    v val;
    final int hashCode;
    hashPosition<i,v> next;
    public hashPosition(i index, v val, int hashCode){
        this.index = index;
        this.val = val;
        this.hashCode = hashCode;
    }
}
