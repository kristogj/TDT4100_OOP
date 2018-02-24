package objectstructures;

public class Partner {
	
	
	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		if (partner == null) {
			this.partner.partner = null;
			this.partner = null;
		}
		else {
			if (this.partner != null) {
				this.partner.setPartner(null);
			}
			this.partner = partner;
			if (partner.getPartner() != null) {
				partner.partner.setPartner(null);
			}
			partner.partner = this;
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("My name is %s and my partner is %s", this.name, this.partner == null ? "null":this.partner.getName());
	}
	
	public static void main(String[] args) {
		Partner p1 = new Partner("A");
		Partner p2 = new Partner("B");
		p1.setPartner(p2);
		System.out.println(p1);
		System.out.println(p2 + "\n");
		
		Partner p3 = new Partner("C");
		Partner p4 = new Partner("D");
		p3.setPartner(p4);
		System.out.println(p3);
		System.out.println(p4 + "\n");
		
		p1.setPartner(p3);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4 + "\n");
		
	}

}
