package banana.util.system;

public enum ViewName {

	LOGIN("login"),
	REGISTER("register"),
	HOMEPAGE("homepage"),
	ADDCCOUNT("addaccount"),
	EDITACCOUNT("editaccount"),
	RESET("reset"),
	CHANGEPASSWORD("changepassword");

	String viewName;

	private ViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return this.viewName;
	}
}
