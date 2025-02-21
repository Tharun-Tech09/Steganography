package com.Steganography.bean;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Steganography {
	private static final HashMap<Character, Integer> charToInt = new HashMap<>();
	private static final HashMap<Integer, Character> intToChar = new HashMap<>();

	static {
		for (int i = 0; i < 255; i++) {
			charToInt.put((char) i, i);
			intToChar.put(i, (char) i);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {

			BufferedImage image = ImageIO.read(new File("Mypic.jpg"));

			System.out.print("Enter secret message: ");
			String msg = scanner.nextLine();
			System.out.print("Enter password: ");
			String password = scanner.nextLine();

			encodeMessage(image, msg);

			ImageIO.write(image, "jpg", new File("Encryptedmsg.jpg"));
			System.out.println("Message encrypted successfully! Saved as Encryptedmsg.jpg");

			System.out.print("Enter passcode for Decryption: ");
			String passcode = scanner.nextLine();

			if (password.equals(passcode)) {
				String decryptedMessage = decodeMessage(image, msg.length());
				System.out.println("Decryption successful! Message: " + decryptedMessage);
			} else {
				System.out.println("Invalid key! Decryption failed.");
			}

		} catch (IOException e) {
			System.out.println("Error loading or saving image: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void encodeMessage(BufferedImage image, String msg) {
		int n = 0, m = 0, z = 0;
		for (char ch : msg.toCharArray()) {
			int value = charToInt.get(ch);
			int pixel = image.getRGB(n, m) & 0xFFFF00;
			pixel |= (value & 0xFF);
			image.setRGB(n, m, pixel);

			n++;
			m++;
			z = (z + 1) % 3;
		}
	}

	private static String decodeMessage(BufferedImage image, int length) {
		StringBuilder message = new StringBuilder();
		int n = 0, m = 0, z = 0;
		for (int i = 0; i < length; i++) {
			int pixel = image.getRGB(n, m);
			int value = pixel & 0xFF;
			message.append(intToChar.get(value));

			n++;
			m++;
			z = (z + 1) % 3;
		}
		return message.toString();
	}
}
