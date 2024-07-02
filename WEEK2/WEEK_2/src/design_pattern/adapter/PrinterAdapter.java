package design_pattern.adapter;

public class PrinterAdapter implements NewPrinter {
 private OldPrinter oldPrinter;

 public PrinterAdapter(OldPrinter oldPrinter) {
     this.oldPrinter = oldPrinter;
 }

 @Override
 public void printDocument(String content) {
     oldPrinter.print(content);
 }
}
