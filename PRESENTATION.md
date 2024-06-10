# The Chaocipher's History
John F. Byrne was born in Ireland in 1880 and he had the idea to create a cipher in 1918, after moving to New York to become a writer. This cipher was called the Chaocipher, where he tried selling from 1918 to 1953 to the government to no avail. Funny enough, this cipher was actually impossible to crack, being unsolved for half a century and also being small enough to fit inside a cigar box. The only reason he couldn't sell the cipher was due to his way of disclosing the information to the government in his attempts to sell it. He just refused to send the full details of his cipher to the government due to him not being a cryptanalyst, always saying that his cipher was indecipherable. This caused him to never be able to sell the cipher and instead in 1953, he created his autobiography, Silent Years. In this book, he included examples of enciphered texts such as the Declaration of Independence and the Gettysburg Address to give the reader examples of ciphertext and plaintext pairs. He wanted people to try and figure out how his cipher worked. His cipher's inner mechanism was never figured out, but in 2010, the chaocipher's inner workings were revealed by Patricia Byrne, John Byrne’s son’s widow.

![image](https://github.com/Stuycs-K/final-project-10-wang-daniel-yeung-yonna/assets/124080285/48b72928-6970-4f5b-8617-42d9ccec2631)

Picture of John F. Byrne

# How the Chaocipher Works
Left Alphabet:  BAZOMLYXITSRQDEPCNKJWHUGVF <br />
Right Alphabet: CKIWLHGFESDQBNZYAXJVUTRPOM <br />
Plain Text: CAT <br />
Zenith: The first letter of the alphabet. <br />
Nadir: The middle letter of the alphabet (letter 14). <br />
Step 1: Engaging the Disks <br />
Make sure the left and right disks are engaged. This means verifying that the first letter of the right and left alphabte match up in the disks. <br />

![image](https://github.com/Stuycs-K/final-project-10-wang-daniel-yeung-yonna/assets/124080285/29578de8-2a05-48d8-a0c4-0e804fb262ca)


As you can see, comparing the plaintext alphabet to the disk, the left disk is read from left to right while the right disk is read from right to left. Both start at the zenith. <br />

Step 2: First Encoded Letter <br />

Rotate the right disk counter clockwise until the zenith (top of the disk) is "C", the first letter in the plaintext. <br />

![image](https://github.com/Stuycs-K/final-project-10-wang-daniel-yeung-yonna/assets/124080285/00860e4f-20a2-498d-bb64-debb47ce3a4b)

Rotating the right disk has also rotated the left disk as well. <br />
This letter on the left disk's zenith is the encoded text's first letter. <br />

Step 3: Permutating the Left Alphabet <br />
Starting Alphabet: BAZOMLYXITSRQDEPCNKJWHUGVF <br />
Remove the second letter of the alphabet, leaving a hole. <br />
B_ZOMLYXITSRQDEPCNKJWHUGVF <br />
Move the letters "ZOMLYXITSRQD" over by one, covering the hole and leaving a new hole in the nadir. <br />
B**ZOMLYXITSRQD**_EPCNKJWHUGVF <br />
Insert the second letter of the alphabet ("A") in the nadir, permutating the left alphabet. <br />
BZOMLYXITSRQD**A**EPCNKJWHUGVF <br />

Step 4: Permutating the Right Alphabet <br />
Starting Alphabet: CKIWLHGFESDQBNZYAXJVUTRPOM <br />
Shift the first letter of the alphabet to the last letter. <br />
KIWLHGFESDQBNZYAXJVUTRPOMC <br />
Remove the third letter of the alphabet, leaving a hole. <br />
KI_LHGFESDQBNZYAXJVUTRPOMC <br />
Shift the letters "LHGFESDQBNZ" over by one, covering the hole and leaving a new hole in the nadir. <br />
KI**LHGFESDQBNZ**_YAXJVUTRPOMC <br />
Insert the third letter of the alphabet ("W") in the nadir, permutating the right alphabet. <br />
KILHGFESDQBNZ**W**YAXJVUTRPOMC <br />

Step 5: Rinse and Repeat <br />
Using the alphabets that were just permutated as the new starting alphabets and repeat this process until everything is encrypted. <br />
Yonna will show how it works using visuals. <br />
The final encrypted text is "BPJ". <br />

Decryption: <br />
The process to decrypt this cipher follows the same step by step process, with a few changes. <br />
In Step 2, instead of rotating the right disk counter clockwise until the first letter of the plaintext is at the zenith, you rotate the left disk clockwise until the first letter of the encrypted text is at the zenith, and the letter at the right disk's zenith is the first letter of the decrypted text. <br />


