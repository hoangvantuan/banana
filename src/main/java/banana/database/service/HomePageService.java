package banana.database.service;

public abstract class HomePageService extends BaseService<HomePageService> {

  protected Integer page;
  protected String key;

  public abstract String initHomePage();

  public abstract String search();

  public Integer getPage() {
    return page;
  }

  public HomePageService setPage(Integer page) {
    this.page = page;
    return this;
  }

  public String getKey() {
    return key;
  }

  public HomePageService setKey(String key) {
    this.key = key;
    return this;
  }

}
