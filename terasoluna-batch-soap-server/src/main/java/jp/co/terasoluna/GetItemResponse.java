//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.7によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.07.28 時間 01:47:05 PM JST 
//


package jp.co.terasoluna;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "price"
})
@XmlRootElement(name = "GetItemResponse")
public class GetItemResponse {

    protected int id;
    protected int price;

    /**
     * idプロパティの値を取得します。
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * idプロパティの値を設定します。
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * priceプロパティの値を取得します。
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * priceプロパティの値を設定します。
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

}
