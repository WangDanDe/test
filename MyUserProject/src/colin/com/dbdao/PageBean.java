package colin.com.dbdao;

public class PageBean {
	private static final int size=5;
	int count;//数据的总条数
	int pageSize;//每页条数
	int pageCount;//一共有多少页
	int currentPage;//当前页
	public PageBean() {
		// TODO 自动生成的构造函数存根
		this.pageSize=size;
		this.currentPage=1;
		
	}
	public PageBean(int pageSize){
		this.pageSize=pageSize;
		this.pageSize=1;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count=count;
		
		//计算条数
		this.pageCount=count%this.pageSize==0?count/this.pageSize:count/this.pageSize+1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static int getSize() {
		return size;
	}
	public int prePage(){
		if(this.currentPage==1){
			return 1;
		}
		return this.currentPage-1;
	}
	public int nextPage(){
		if(this.currentPage==this.pageCount){
			return this.getPageCount();
		}else{
			return this.currentPage+1;
		}
	}
	public int getStart(){//开始条数
		return this.pageSize*(this.getCurrentPage()-1);
	}
	
}
