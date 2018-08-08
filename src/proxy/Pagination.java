package proxy;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	int count,pageRow, blockSize,lastPage,beginPage, 
	endPage,pageNum,beginRow,endRow,prevBlock,nextBlock;
	boolean existPrev,existNext;
	
	
	@Override
	public void carryOut(Object o) {
		this.pageNum = (int) o;
		this.pageRow = 5;
		this.blockSize = 5;
		this.count = MemberServiceImpl.getInstance().memberCount();
		//this.count = 65;
				
		this.lastPage = count%pageRow>0? count/pageRow+1:count/pageRow;
		this.beginPage = pageNum-((pageNum-1)%blockSize);
		//this.endPage = count/pageRow<blockSize? lastPage:blockSize;
		this.endPage = ((beginPage+pageRow-1)<count)? beginPage+blockSize-1:count;
		
		this.beginRow = (pageRow*pageNum)-(pageRow-1);
		this.endRow = pageNum ==lastPage? pageRow*pageNum-pageRow+(count%pageRow):pageRow*pageNum;
		
	    this.prevBlock = beginPage - blockSize;
        this.nextBlock = beginPage + blockSize;
        this.existPrev = (prevBlock>=0);
        this.existNext = (nextBlock<=lastPage);
	
        //this.blockCount = (pageCount%blockSize==0)? pageCount/blockSize : pageCount/blockSize+1;
    
    
	}
}
