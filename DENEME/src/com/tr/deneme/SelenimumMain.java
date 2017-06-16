package com.tr.deneme;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class SelenimumMain {
	private WebDriver webdriver;

	public static void main(String[] args) {
		SelenimumMain selenium = new SelenimumMain();
		selenium.sayfaBilgileri();

	}

	public ArrayList<SayfaElemanlar> sayfaBilgileri() {
		ArrayList<SayfaElemanlar> list = new ArrayList<SayfaElemanlar>();
//		String baseUrl = "http://katalog.wunderfilter.com/AracSecimi.aspx";
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		webdriver = new ChromeDriver();
//		webdriver.get(baseUrl);
		
		FirefoxProfile profile = new FirefoxProfile();  	
	  	profile.setPreference("network.auth.force-generic-ntlm", false);
	  	profile.setPreference("network.auth.force-generic-ntlm-v1", true);
	  	profile.setPreference("network.automatic-ntlm-auth.allow-proxies", false);
	  	profile.setPreference("network.proxy.type", 1);
	  	profile.setPreference("network.proxy.http", "proxy2.uyap.gov.tr");     
	  	profile.setPreference("network.proxy.http_port", 80);  
	  	
	    	System.setProperty("webdriver.firefox.marionette","geckodriver");
	    	
	    	webdriver = new FirefoxDriver(profile);    	
	    	String baseUrl = "http://katalog.wunderfilter.com/AracSecimi.aspx";  
	    	webdriver.manage().window().maximize();
	    	webdriver.get(baseUrl);
		
		

		ArrayList<String> ureticiFirmalar = new ArrayList<>();
		ArrayList<String> modeller = new ArrayList<>();

		// *[@id="ContentPlaceHolder1_drpUretici"]
		Select dropDown = new Select(webdriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_drpUretici']")));
		List<WebElement> elementCount = dropDown.getOptions();
		int itemSize = elementCount.size();
		for (int i = 0; i < itemSize; i++) {
			String optionsValue = elementCount.get(i).getText();
			System.out.println(optionsValue);
			ureticiFirmalar.add(optionsValue);

		}
		int k = 1;
		int ureticiFirmalarSayi =101;
		int ureticiFirmalarSiteSayisi = ureticiFirmalar.size();

		for (int i = ureticiFirmalarSayi; i < ureticiFirmalarSiteSayisi; i++) {
		
			Select dropDowna = new Select(webdriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_drpUretici']")));

			dropDowna.selectByIndex(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// *[@id="ContentPlaceHolder1_drpModel"]
			Select dropDownb = new Select(webdriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_drpModel']")));
			List<WebElement> elementModelCount = dropDownb.getOptions();
			int itemModelSize = elementModelCount.size();
			
			int j = 1;
			int cc = 0;
			for (; j < itemModelSize; j++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Select dropDownc = new Select(
						webdriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_drpModel']")));
				List<WebElement> elementModelCountc = dropDownc.getOptions();
				
				modeller.clear();
				for (int l = 1; l < itemModelSize; l++) {
					
					String optionsValueb = elementModelCountc.get(l).getText();
					System.out.println(optionsValueb);
					modeller.add(optionsValueb);
				}
				
				dropDownc.selectByIndex(j);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			
				//buradan devam
				
				//*[@id="typesForm:typeDataTable:tb"]/tr
				//*[@id="typesForm:typeDataTable:tb"]/tr[2]
				//*[@id="typesForm:typeDataTable:tb"]/tr[1]
				//*[@id="typesForm:typeDataTable:tb"]
				//*[@id="ContentPlaceHolder1_aracModelTipleri"]/table
				//*[@id="typesForm:typeDataTable:tb"]
				
				List<WebElement> TRcount = webdriver.findElements(By.xpath("//*[@id='typesForm:typeDataTable:tb']/tr"));
				System.out.println("model sayısı"+TRcount.size());
				int modelTipiSayisi = TRcount.size();
				StringBuilder modelTipleriDizisi = new StringBuilder();
				ArrayList<String> modelTipleri = new ArrayList<>();
				int l2 = 0;
				
				int m = 0;
				
				
				//for (k = 1; k < modelTipiSayisi+1; k++) {
					for (int z = 1; z < modelTipiSayisi+1; z++) {
						int k2 = 1;
						for (; k2 < 6; k2++) {
							String dummyClass = "//*[@id='typesForm:typeDataTable:tb']/tr["+z+"]/td["+k2+"]";
							String text = webdriver.findElement(By.xpath(dummyClass)).getText();
							System.out.println("dummyClasss budur"+text);
							if (text.trim().equals("")|| text.equals(null)) {
								text="--";
							}
							modelTipleriDizisi.append(text+"%");
					
						}
						 modelTipleriDizisi = modelTipleriDizisi.deleteCharAt(modelTipleriDizisi.length()-1);
						 modelTipleri.add(modelTipleriDizisi.toString());
						 modelTipleriDizisi= null;
						 modelTipleriDizisi = new StringBuilder();
					}
					
			
					
					
					
//					String hava = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd0']")).getText();
//					String yag = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd0']")).getText();
//					String yakit = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd0']")).getText();
//					String klima = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd0']")).getText();
//					String digerUrunler = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd0']")).getText();
			
								
					
					//*[@id="parts:productdata:tb"]/tr
					//*[@id="parts:productdata:0:HavaTd0"]
					//*[@id="parts:productdata:0:YagTd0"]
					//*[@id="parts:productdata:0:YakitTd0"]
					//*[@id="parts:productdata:0:KlimaTd0"]
					//*[@id="parts:productdata:0:DigerUrunlerTd0"]
					String[] modelTipSon = {"","","","",""};
					
					int l = 0;
					for (; l <=j; ++l) {
						System.out.println("üreten firma"+ureticiFirmalar.get(i));
						for (;l2 < modeller.size(); ++l2) {
							System.out.println("model"+modeller.get(l2));
							for (; m <modelTipiSayisi; ++m) {
								modelTipSon = (modelTipleri.get(m)).split("%");
								for (int n = 0; n < modelTipSon.length; n++) {
									System.out.println("modelTipler özellikleri"+modelTipSon[n]);
									
								}
								int aradeger = m;
								String modelTipiLink = "//*[@id='ContentPlaceHolder1_rptAracModelTipleri_btnModelTip_"+aradeger+"']";
								
								
								try {
									webdriver.findElement(By.xpath(modelTipiLink)).click();
									Thread.sleep(2000);
								} catch (Exception e) {
									continue;
								
								}
							
								List<WebElement> TRfiltrelerSatirSayisi = webdriver.findElements(By.xpath(".//*[@id='parts:productdata:tb']/tr"));
								System.out.println("filtre Sayısı"+TRfiltrelerSatirSayisi.size());
								
								if (TRfiltrelerSatirSayisi.size() ==1) {
									String hava = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd0']")).getText();
									String yag = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd0']")).getText();
									String yakit = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd0']")).getText();
									String klima = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd0']")).getText();
									String digerUrunler = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd0']")).getText();
									
									
									String uretici;
									String model;
									String modelTipi;
									String motorKodu;
									String kw;
									String ps;
									String uretimSuresi;
									//String hava;
									//String yag;
									String yakıt;
									String icMekan;
									String diger;								
									
									System.out.println("üreten firma"+ureticiFirmalar.get(i));
									System.out.println("modeller"+modeller.get(l2));
									System.out.println("modelTipler özellikleriModel Tipi"+modelTipSon[0]);
									System.out.println("modelTipler özellikleri Motor Kodu"+modelTipSon[1]);
									System.out.println("modelTipler özellikleri Motor kw"+modelTipSon[2]);
									System.out.println("modelTipler özellikleri Motor Ps"+modelTipSon[3]);
									System.out.println("modelTipler özellikleri Motor Üretim süresi"+modelTipSon[4]);
									
									System.out.println("hava filtresi"+hava);
									System.out.println("hava filtresi"+yag);
									System.out.println("hava filtresi"+yakit);
									System.out.println("hava filtresi"+klima);
									System.out.println("hava filtresi"+digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava, yag, yakit, klima, digerUrunler);
									
								}
								if (TRfiltrelerSatirSayisi.size() ==2) {
									String hava = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd0']")).getText();
									String yag = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd0']")).getText();
									String yakit = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd0']")).getText();
									String klima = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd0']")).getText();
									String digerUrunler = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd0']")).getText();
									
									String hava1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd1']")).getText();
									String yag1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd1']")).getText();
									String yakit1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd1']")).getText();
									String klima1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd1']")).getText();
									String digerUrunler1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd1']")).getText();
									
									
									String uretici;
									String model;
									String modelTipi;
									String motorKodu;
									String kw;
									String ps;
									String uretimSuresi;
									//String hava;
									//String yag;
									String yakıt;
									String icMekan;
									String diger;								
									
									System.out.println("üreten firma"+ureticiFirmalar.get(i));
									System.out.println("modeller"+modeller.get(l2));
									System.out.println("modelTipler özellikleriModel Tipi"+modelTipSon[0]);
									System.out.println("modelTipler özellikleri Motor Kodu"+modelTipSon[1]);
									System.out.println("modelTipler özellikleri Motor kw"+modelTipSon[2]);
									System.out.println("modelTipler özellikleri Motor Ps"+modelTipSon[3]);
									System.out.println("modelTipler özellikleri Motor Üretim süresi"+modelTipSon[4]);
									
									System.out.println("hava filtresi"+hava);
									System.out.println("hava filtresi"+yag);
									System.out.println("hava filtresi"+yakit);
									System.out.println("hava filtresi"+klima);
									System.out.println("hava filtresi"+digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava, yag, yakit, klima, digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava1, yag1, yakit1, klima1, digerUrunler1);
									
								}
								if (TRfiltrelerSatirSayisi.size() == 3) {
									String hava = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd0']")).getText();
									String yag = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd0']")).getText();
									String yakit = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd0']")).getText();
									String klima = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd0']")).getText();
									String digerUrunler = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd0']")).getText();
									
									String hava1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd1']")).getText();
									String yag1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd1']")).getText();
									String yakit1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd1']")).getText();
									String klima1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd1']")).getText();
									String digerUrunler1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd1']")).getText();
									
									String hava2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd2']")).getText();
									String yag2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd2']")).getText();
									String yakit2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd2']")).getText();
									String klima2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd2']")).getText();
									String digerUrunler2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd2']")).getText();
									
									
									String uretici;
									String model;
									String modelTipi;
									String motorKodu;
									String kw;
									String ps;
									String uretimSuresi;
									//String hava;
									//String yag;
									String yakıt;
									String icMekan;
									String diger;								
									
									System.out.println("üreten firma"+ureticiFirmalar.get(i));
									System.out.println("modeller"+modeller.get(l2));
									System.out.println("modelTipler özellikleriModel Tipi"+modelTipSon[0]);
									System.out.println("modelTipler özellikleri Motor Kodu"+modelTipSon[1]);
									System.out.println("modelTipler özellikleri Motor kw"+modelTipSon[2]);
									System.out.println("modelTipler özellikleri Motor Ps"+modelTipSon[3]);
									System.out.println("modelTipler özellikleri Motor Üretim süresi"+modelTipSon[4]);
									
									System.out.println("hava filtresi"+hava);
									System.out.println("hava filtresi"+yag);
									System.out.println("hava filtresi"+yakit);
									System.out.println("hava filtresi"+klima);
									System.out.println("hava filtresi"+digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava, yag, yakit, klima, digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava1, yag1, yakit1, klima1, digerUrunler1);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava2, yag2, yakit2, klima2, digerUrunler2);
									
								}
								if (TRfiltrelerSatirSayisi.size() == 4) {
									String hava = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd0']")).getText();
									String yag = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd0']")).getText();
									String yakit = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd0']")).getText();
									String klima = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd0']")).getText();
									String digerUrunler = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd0']")).getText();
									
									String hava1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd1']")).getText();
									String yag1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd1']")).getText();
									String yakit1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd1']")).getText();
									String klima1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd1']")).getText();
									String digerUrunler1 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd1']")).getText();
									
									String hava2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd2']")).getText();
									String yag2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd2']")).getText();
									String yakit2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd2']")).getText();
									String klima2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd2']")).getText();
									String digerUrunler2 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd2']")).getText();
									
									String hava3 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:HavaTd3']")).getText();
									String yag3 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YagTd3']")).getText();
									String yakit3 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:YakitTd3']")).getText();
									String klima3 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:KlimaTd3']")).getText();
									String digerUrunler3 = webdriver.findElement(By.xpath("//*[@id='parts:productdata:0:DigerUrunlerTd3']")).getText();
									
									
									String uretici;
									String model;
									String modelTipi;
									String motorKodu;
									String kw;
									String ps;
									String uretimSuresi;
									//String hava;
									//String yag;
									String yakıt;
									String icMekan;
									String diger;								
									
									System.out.println("üreten firma"+ureticiFirmalar.get(i));
									System.out.println("modeller"+modeller.get(l2));
									System.out.println("modelTipler özellikleriModel Tipi"+modelTipSon[0]);
									System.out.println("modelTipler özellikleri Motor Kodu"+modelTipSon[1]);
									System.out.println("modelTipler özellikleri Motor kw"+modelTipSon[2]);
									System.out.println("modelTipler özellikleri Motor Ps"+modelTipSon[3]);
									System.out.println("modelTipler özellikleri Motor Üretim süresi"+modelTipSon[4]);
									
									System.out.println("hava filtresi"+hava);
									System.out.println("hava filtresi"+yag);
									System.out.println("hava filtresi"+yakit);
									System.out.println("hava filtresi"+klima);
									System.out.println("hava filtresi"+digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava, yag, yakit, klima, digerUrunler);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava1, yag1, yakit1, klima1, digerUrunler1);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava2, yag2, yakit2, klima2, digerUrunler2);
									CsvWriterAppendExample.CsvWriterYaz(ureticiFirmalar.get(i).toString(), modeller.get(cc), modelTipSon[0], modelTipSon[1],
											modelTipSon[2],modelTipSon[3], modelTipSon[4], hava3, yag3, yakit3, klima3, digerUrunler3);
									
								}
								
								try {
									webdriver.navigate().back();
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}
								JavascriptExecutor jse = (JavascriptExecutor)webdriver;
								jse.executeScript("window.scrollBy(0,450)", "");
								
							}
						}
						
						
						
					}
					
					
					
					//list.add(new SayfaElemanlar(ureticiFirma, modelTipi, modelTipiSon, motorKodu, motorKw, motorPs, uretimSuresi, hava, yag, yakit, klima, digerUrunler));
					
					
				//}
					cc++;
			}
j=1;
		}
		list.add(new SayfaElemanlar(null, null, null, null, null, null, null, null, null, null, null, null));
		return list;

	}

}
