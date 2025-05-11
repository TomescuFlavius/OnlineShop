package app.system;

import app.products.models.Product;

public class CartItem {

     private Product product;
     private int cantitate;

     public CartItem(Product product, int cantitate) {
          this.product = product;
          this.cantitate = cantitate;
     }

     public Product getProduct() {
          return product;
     }

     public void setProduct(Product product) {
          this.product = product;
     }

     public int getCantitate() {
          return cantitate;
     }

     public void setCantitate(int cantitate) {
          this.cantitate = cantitate;
     }

     public String descriere(){
          String text="";
          text+="cantitate:"+this.cantitate+"\n";
          text+="product:" +this.product.getName()+"\n";
          return text;
     }
}
