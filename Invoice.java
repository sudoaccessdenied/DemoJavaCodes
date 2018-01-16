/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author mathg_000
 */
public class Invoice {
    
    
 

 
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "e:/hello_mirrored_margins.pdf";
 
    /**
     * Creates a PDF file: hello_mirrored_margins
     * @param    args    no arguments needed
     * @throws com.itextpdf.text.DocumentException
     * @throws java.io.IOException
     */
    
    
    
    
    
    
    
    public static void main(String[] args) throws DocumentException, IOException {
        
    
    


        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer =PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        document.setPageSize(PageSize.A4);
        document.setMargins(15, 15, 15, 15);
        document.setMarginMirroring(true);
        // step 3
        document.open();
        // write your document here
        
        
        
        
        //--------------------------------------------------------------Do not edit it----------------------------------------------------------------
        
        Phrase[] phrase =  {new Phrase(),new Phrase(),new Phrase(),new Phrase()};
        Paragraph[] paragraph = {new Paragraph(),new Paragraph(),new Paragraph(),new Paragraph()};
        
        
        phrase[0].add(new Chunk("HOTEL PUNNU INTERNATIONAL",new Font(Font.FontFamily.HELVETICA,18,Font.BOLD)));
        phrase[0].add(Chunk.NEWLINE);
        
        Font firstHeading = new Font(Font.FontFamily.COURIER, 15, Font.NORMAL);
        Chunk title = new Chunk("LIQUID BAR & RESTAURANT",firstHeading);
        phrase[0].add(title);
        phrase[0].add(Chunk.NEWLINE);
        //phrase[0].add(Chunk.NEWLINE);
        
        phrase[0].add(new Chunk("7-Court Road,Amritsar",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL)));
        phrase[0].add(Chunk.NEWLINE);
        
        
        phrase[0].add(new Chunk("Ph:0183-5016767",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL)));
        phrase[0].add(Chunk.NEWLINE);
        
        
        phrase[0].add(new Chunk("Sale Invoice",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC)));
        phrase[0].add(Chunk.NEWLINE);
        phrase[0].add(Chunk.NEWLINE);
        paragraph[0].add(phrase[0]);
        paragraph[0].setAlignment(Element.ALIGN_CENTER);   
        document.add(paragraph[0]);
      
        //------------------------------------------------------------------------------------------------------------------------
        
        
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        //Add Invoice No. Here 
        //Add system date 
        //Add time
        //Add Cahier Name
        
        PdfPCell top1 = getCell("INVOICE NO.:addNoHere",PdfPCell.ALIGN_LEFT);//Add invoice no. here;
        top1.setBorderWidthTop(1f);
        table.addCell(top1);
        PdfPCell top2 =getCell("DATE:1/14/2018",PdfPCell.ALIGN_RIGHT); //Add System current Date here;
        top2.setBorderWidthTop(1f);
        table.addCell(top2);
        PdfPCell top3 =getCell("TIME:8:30 PM",PdfPCell.ALIGN_LEFT);//Add System current TIME here;
        top3.setBorderWidthBottom(1f);
        table.addCell(top3);
        PdfPCell top4 =getCell("CASHIER NAME:NISHANT",PdfPCell.ALIGN_RIGHT);//Add System USER NAME here;
        top4.setBorderWidthBottom(1f);
        table.addCell(top4);
        document.add(table);
        document.add(addEmptyLine(new Paragraph(""), new Phrase(new Chunk(""))));

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------
       if(true) {// Add Check Box condition here
        //if customer selected hotel then print below
        PdfPTable table2 = new PdfPTable(4);
        table2.setWidthPercentage(100);
        table2.setWidths(new float[] {69f,70f,45f,145f});
        
        
        PdfPCell cellH = createHeaderCell("BILL TO: ");
        cellH.setColspan(4);
        cellH.setBorderWidthBottom(2f);
        cellH.setBorderWidthRight(2f);
        cellH.setHorizontalAlignment(Element.ALIGN_LEFT);
        table2.addCell(cellH);
        table2.addCell(createValueCell("CUSTOMER NAME:"));
        table2.addCell(createValueCell("Nishant"));//Add customer Name here
        table2.addCell(createValueCell("ADDRESS:"));
        table2.addCell(createValueCell("439,New Azad Nagar,Amritsar"));//Add address here
        table2.addCell(createValueCell("MOBILE NO:"));
        table2.addCell(createValueCell("+918528796341"));//Add mobile no. here
        table2.addCell(createValueCell("ZIPCODE:"));
        table2.addCell(createValueCell("143001"));//Add zipcode here
         document.add(table2);
        
        //------------------------------------------------------------------------------
        document.add(addEmptyLine(new Paragraph(""), new Phrase(new Chunk(""))));
        
         PdfPTable table3 = new PdfPTable(7);
        table3.setWidthPercentage(100);
        
        //table3.setWidths(new float[] {35f,150f,30f,45f,45f});
        
        
 
    PdfPCell cell2 = createTitleCell("HOTEL BILL", 7);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);    
        
        cell2.setBorder(0);
        cell2.setPadding(4f);
        cell2.setBorderWidthBottom(2f);// For Adding Bottom Border
        table3.addCell(cell2);
        table3.addCell(createHeaderCell("ROOM #"));
        table3.addCell(createHeaderCell("DESC."));//ROOM TYPE // OTHER ROOM HEATER
        table3.addCell(createHeaderCell("CHECK IN"));
        table3.addCell(createHeaderCell("CHECK OUT"));
        table3.addCell(createHeaderCell("# NIGHT"));
        table3.addCell(createHeaderCell("PRICE/NIGHT"));
        table3.addCell(createHeaderCell("LINE"));
        //-------------------------------------------------------------------------------------------------
        //ADD TABLE DATA HERE use for loop
        //PdfPCell cellTableNo =createValueCell("T101"); 
        //cellTableNo.setRowspan(3);// specify no. of rows to be printed
        //cellTableNo.setVerticalAlignment(Element.ALIGN_MIDDLE);
       // table3.addCell(cellTableNo);
          
      for(int i =0;i<1;i++){// specify no. of rows to be of JHotelTable
          table3.addCell(createValueCell("101"));//Add room no.
          table3.addCell(createValueCell("DELUX"));// Room type or services
          table3.addCell(createValueCell("1/16/2018"));//Check In Date
          table3.addCell(createValueCell("1/17/2018"));//Check Out Date
          table3.addCell(createValueCell("1"));// #Nights
          table3.addCell(createValueCell("1500"));//price per night
          table3.addCell(createValueCell("1500"));//line total
          
      }
        
        
        //Add Total here  
        table3.addCell(createTitleCell("SUBTOTAL:", 6));
        table3.addCell(createTitleCell("Rs.1500", 1));// ADD TOTAL HERE
        table3.addCell(createTitleCell("SGST:", 6));
        table3.addCell(createTitleCell("Rs.15", 1));// ADD SGST HERE
        table3.addCell(createTitleCell("SGST:", 6));
        table3.addCell(createTitleCell("Rs.15", 1));//ADD CGST HERE
        table3.addCell(createTitleCell("TOTAL:", 6));
        table3.addCell(createTitleCell("Rs.1530", 1));
        document.add(table3);
        document.add(addEmptyLine(new Paragraph(""), new Phrase(new Chunk(""))));
        
    }
        
        
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      //If User slected Restauran/Bar CheckBox Use Below Format
        if(true){
        PdfPTable table1 = new PdfPTable(5);
        table1.setWidthPercentage(100);
        
        table1.setWidths(new float[] {35f,150f,30f,45f,45f});
        
        
 
    PdfPCell cell = createTitleCell("RESTAURANT /BAR BILL", 5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);    
        
        cell.setBorder(0);
        cell.setPadding(4f);
        cell.setBorderWidthBottom(2f);// For Adding Bottom Border
        table1.addCell(cell);
        table1.addCell(createHeaderCell("TABLE #"));
        table1.addCell(createHeaderCell("ITEMS"));
        table1.addCell(createHeaderCell("RATE"));
        table1.addCell(createHeaderCell("QUANTITY"));
        table1.addCell(createHeaderCell("AMOUNT"));
      
        //ADD TABLE DATA HERE use for loop
        PdfPCell cellTableNo =createValueCell("T101"); //Add table no. here 
        cellTableNo.setRowspan(3);// specify no. of rows to be printed
        cellTableNo.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table1.addCell(cellTableNo);
          
      for(int i =0;i<3;i++){// specify no. of rows to be printed
          table1.addCell(createValueCell("Tea"));//Item
          table1.addCell(createValueCell("30"));//price
          table1.addCell(createValueCell("2"));//quantity
          table1.addCell(createValueCell("60"));//line total
       
      }
        
        
        //Add Total here  
        table1.addCell(createTitleCell("SUBTOTAL:", 4));
        table1.addCell(createTitleCell("Rs.240", 1));// ADD TOTAL HERE
        table1.addCell(createTitleCell("SGST:", 4));
        table1.addCell(createTitleCell("Rs.15", 1));// ADD SGST HERE
        table1.addCell(createTitleCell("SGST:", 4));
        table1.addCell(createTitleCell("Rs.15", 1));//ADD CGST HERE
        table1.addCell(createTitleCell("TOTAL:", 4));
        table1.addCell(createTitleCell("Rs.270", 1));//Add total here
        document.add(table1);
        }
        
        
        
        //document.add(addEmptyLine(new Paragraph(""), new Phrase(new Chunk(""))));
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Restaurant Bill total
        //Hotel Bill total
        //Net Amount
        //Received Amount
  
        phrase[2].add(new Chunk("------------------------------------------------------------------------------------------------------------------------------------------",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
        phrase[2].add(Chunk.NEWLINE);
      
        //DISCOUNT AMOUNT
        phrase[2].add(new Chunk("DISCOUNT AMOUNT: Rs. 0/-",new Font(Font.FontFamily.COURIER,12,Font.BOLD)));
        phrase[2].add(Chunk.NEWLINE);
        
        
        
        //NET AMOUNT
        
        phrase[2].add(new Chunk("NET AMOUNT: Rs. 270/-",new Font(Font.FontFamily.COURIER,12,Font.BOLD)));
        phrase[2].add(Chunk.NEWLINE);
        
        //Received Amount
        
        phrase[2].add(new Chunk("RECEIVED AMOUNT: Rs. 270/-",new Font(Font.FontFamily.COURIER,12,Font.BOLD)));
        phrase[2].add(Chunk.NEWLINE);
        
        //BALANCE
        phrase[2].add(new Chunk("BALANCE: Rs. 0/-",new Font(Font.FontFamily.COURIER,12,Font.BOLD)));
        phrase[2].add(Chunk.NEWLINE);
        
        
        phrase[2].add(new Chunk("------------------------------------------------------------------------------------------------------------------------------------------",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
       // phrase[2].add(Chunk.NEWLINE);
        
        phrase[2].add(new Chunk("GSTIN: 656521G656565",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD)));//ADD YOUR GST NO. HERE
        phrase[2].add(Chunk.NEWLINE);

       
        paragraph[2].add(phrase[2]);
        document.add(paragraph[2]);
        
        phrase[3].add(new Chunk("Thank you,Please Visit Again",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));//ADD YOUR GST NO. HERE
        
      
        
        paragraph[3].add(phrase[3]);
        paragraph[3].setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph[3]);
        
        //--------------------------Add footer here----------
        MyFooter myFooter = new MyFooter();
        myFooter.onEndPage(writer, document);
        
        
        document.addCreator("Nishant");
        document.addHeader("a", "Nishnat");
        document.close();
    }
    
    
    
    
     private static Paragraph addEmptyLine(Paragraph p,Phrase ph) {
        Paragraph space = p ;
        Phrase spacep= ph;
        spacep.add(Chunk.NEWLINE);
        space.add(spacep);
        return space;
    }
     
     // create cells
    private static PdfPCell createValueCell(String text){
        // font
        Font font = new Font(Font.FontFamily.COURIER, 11, Font.BOLD, BaseColor.BLACK);
 
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
 
        // set style
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         // padding
        cell.setPadding(4f);
 
        // background color
        cell.setBackgroundColor(new BaseColor(255,255,255));
 
        // border
        //cell.setBorder(0);
        //cell.setBorderWidthLeft(1f);
        //cell.setBorderWidthRight(1f);
        
        return cell;
    }
    
    
    private static PdfPCell createHeaderCell(String text){
        // font
        Font font = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);
 
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
 
        // set style
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         // padding
        cell.setPadding(3f);
 
        // background color
        cell.setBackgroundColor(new BaseColor(255,255,255));
 
        // border
        
        return cell;
    }
    
    
    private static PdfPCell createTitleCell(String text,int s){
        // font
        Font cellFont = new Font(Font.FontFamily.HELVETICA,11,Font.BOLD,BaseColor.BLACK);
 
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,cellFont));
        cell.setColspan(s);
 
        // set style
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         // padding
      
 
        // background color
        cell.setBackgroundColor(new BaseColor(255,255,255));
        
        
        
        // padding
        cell.setPadding(2f);
       
 
        // background color
        cell.setBackgroundColor(new BaseColor(255,255,255));
 
        // border
        //cell.setBorder(0);
 
        return cell;
    }
    
    public static PdfPCell getCell(String str,int alignment){
        
        Font catFont = new Font(Font.FontFamily.COURIER, 11,Font.BOLD, BaseColor.BLACK);

        Phrase phrase = new Phrase(new Chunk(str,catFont));
        phrase.setFont(catFont);
        
    PdfPCell cell = new PdfPCell(phrase);
    cell.setPadding(0);
    cell.setHorizontalAlignment(alignment);
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    cell.setBorder(PdfPCell.NO_BORDER);
    //cell.setBorderWidthTop(1);
    //cell.setBorderWidthBottom(1);
    cell.setPaddingTop(3f);
    cell.setPaddingBottom(4f);
    return cell;
    }
    
    
    }
    
    
    

