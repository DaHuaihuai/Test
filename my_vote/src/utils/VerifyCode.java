package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;


public class VerifyCode {
	private int width=70;
	private int height=35;
	private Random random=new Random();
	private String codes="23456789abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	private String[] fontNames={"宋体","华文楷体","黑体","微软雅黑"};
	//private Color color;
	private String textString;
	
	//产生随机字体
	private Font randomFont() {
		//通过随机数产生0~3，选择对应字体
		int index=random.nextInt(fontNames.length);
		String fontName = fontNames[index];
		//随机字号
		int size = random.nextInt(5)+24;
		//随机类型
		int style = random.nextInt(4);
		return new Font(fontName, style, size);	
	}
	
	//产生随机颜色
	private Color randomColor() {
		int r = random.nextInt(155);
		int g = random.nextInt(155);
		int b = random.nextInt(155);
		return new Color(r, g, b);
	}
	
	//产生干扰线
	private void drawLine(BufferedImage image) {
		int num=3;
		//得到原图的画笔
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			int x2=random.nextInt(width);
			int y2=random.nextInt(height);
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(1.5F));
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	
	//随机生成字符
	private char randomChar(){
		int index=random.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	//生成图片
	private BufferedImage createImage() {
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, width, height);
		return image;
	}
	
	public BufferedImage getImage(){
		BufferedImage image = createImage();
		Graphics2D graphics2d=(Graphics2D)image.getGraphics();
		StringBuilder sBuilder=new StringBuilder();//装载生成的验证码文本
		for(int i=0; i<4;i++){
			String s =randomChar()+"";
			sBuilder.append(s);
			float x= i * width / 4;
			float y= height-5;
			graphics2d.setFont(randomFont());
			graphics2d.setColor(randomColor());
			graphics2d.drawString(s, x, y);
		}
		this.textString=sBuilder.toString();
		drawLine(image);
		return image;
	}
	
	//返回验证码
	public String getText() {
		return this.textString;
		
	}
	
	//保存图片到指定位置
	public static void output(BufferedImage image, OutputStream out) throws IOException{
		ImageIO.write(image, "JPEG", out);
	}

}
