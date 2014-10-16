package org.jsoup.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParserExample1 {
	public static void main(String[] args) {

		Document doc;
		try 
		{

			// need http protocol
			doc = Jsoup.connect("http://in.linkedin.com/in/nishanpatel").get();

			// get page title
			String title = doc.title();
			String[] title1 = new String[] { title };
			List<String> strs = Arrays.asList(title1);
			String e = "";
			for (int n = 0; n< strs.size(); n++)
			{
				System.out.println( strs.get(n));
				BufferedWriter bw = new BufferedWriter(new FileWriter("/home/serendio/myschool1.txt"));
				bw.write(strs.get(n));
				//bw.write(link.attr("href"));
				//bw.write(link.text());
				
				bw.flush();
				bw.close();

			}
			        //System.out.println("title : " + title);
					//System.out.println("\nlink : " + link.attr("href"));
					String text = doc.text();
					String[] text1 = new String[] { text }; 
					List<String> strs1 = Arrays.asList(text1);
					String f = "";
					for (int n = 0; n< strs1.size(); n++)
					{
						System.out.println( strs1.get(n));
						BufferedWriter bw = new BufferedWriter(new FileWriter("/home/serendio/myschool.txt"));
						bw.write(strs1.get(n));
						//bw.write(link.attr("href"));
						//bw.write(link.text());
						
						bw.flush();
						bw.close();

					}
					

					// get all links
					Elements links = doc.select("a[href]");
					for (Element link : links) 
					{
						String s = link.toString();
						String[] s1 = new String[] { s };

						List<String> strs2 = Arrays.asList(s1);
						String t = "";
						for (int i = 0; i < strs2.size(); i++) 
						{
							System.out.println(strs2.get(i));
							//System.out.println("\nlink : " + link.attr("href"));
		                    //System.out.println("text : " + link.text());
		                    
							String content1 = "\nlink : " + link.attr("href");
							
							// if file doesnt exists, then create it

							BufferedWriter bw = new BufferedWriter(new FileWriter("/home/serendio/myschool.txt"));
							bw.write(strs2.get(i));
							//bw.write(link.attr("href"));
							//bw.write(link.text());
							
							bw.flush();
							bw.close();
				       }
			}
			 // get the value from href attribute

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
