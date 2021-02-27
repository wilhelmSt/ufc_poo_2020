import java.util.List;

public class ContactPlus extends Contact {
    public boolean starred;

    public ContactPlus(String id, List<Fone> fone) {
        super(id, fone);
        this.starred = false;
    }

    public void setBookmark(String id) {
        if(this.starred) {
            return;
        } else {
            this.starred = true;
        }
    }

    @Override
    public String toString() {
        if(this.starred) {
            System.out.print("@ ");
        } else {
            System.out.print("- ");
        }
        return super.toString();
    }
}
