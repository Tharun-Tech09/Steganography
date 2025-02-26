**Steganography - Secure Data Hiding in Images**

**Overview**

This project implements a simple steganography technique to hide and retrieve secret messages within an image. The program encodes a message by modifying pixel values and retrieves it upon entering the correct password.

**Features**

Encrypts a secret message within an image.

Decrypts the hidden message using a password.

Uses basic pixel manipulation for data encoding.

**Technologies Used**

Java

Java AWT and ImageIO for image processing

**Installation & Usage**

**Prerequisites**

Ensure you have the following installed:

Java Development Kit (JDK 17 or higher)

IntelliJ IDEA or any Java IDE

**Steps to Run**

1.Clone this repository:

  git clone https://github.com/Tharun-Tech09/Steganography.git

2.Open the project in your Java IDE.

3.Ensure the image Mypic.jpg is present in the root directory.

4.Compile and run the Java file:

  javac com/Steganography/bean/Steganography.java
  java com.Steganography.bean.Steganography

5.Follow the on-screen instructions:

  Enter a message to encrypt.

  Provide a password for security.

  The encrypted image is saved as Encryptedmsg.jpg.

  Enter the correct passcode to decrypt the message.

**Example Usage**

Enter secret message: Hello World!
Enter password: mysecurekey
Message encrypted successfully! Saved as Encryptedmsg.jpg

Enter passcode for Decryption: mysecurekey
Decryption successful! Message: Hello World!

**File Structure**

Steganography/
│── com/Steganography/bean/Steganography.java
│── Mypic.jpg
│── Encryptedmsg.jpg (Generated after encryption)
│── README.md
