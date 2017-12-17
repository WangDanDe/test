package colin.com.dbdao;

public class PageBean {
	private static final int size=5;
	int count;//���ݵ�������
	int pageSize;//ÿҳ����
	int pageCount;//һ���ж���ҳ
	int currentPage;//��ǰҳ
	public PageBean() {
		// TODO �Զ����ɵĹ��캯�����
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
		
		//��������
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
	public int getStart(){//��ʼ����
		return this.pageSize*(this.getCurrentPage()-1);
	}
	
}
