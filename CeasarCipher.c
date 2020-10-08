/*
Simple Caesar Cipher Methods to encryt and decrypt simple strings with no
spaces. This program is limited to alphabet characters only, no spaces or
punctuation. Practice to understand caesar cipher implementaion.
*/
#include <stdio.h>

//Encrypt method to take string of characters and shift each character
//using the key provided by the user, neccessary parameters plaintext
// and key.
void Encrypt(char plaintext[1000], int key)
{
  int i, ch;

  //for the length of the string entered by the user
  for(i = 0; plaintext[i] != '\0'; i++)
  {
     ch = plaintext[i];
     //if lowercase
     if(ch >= 'a' && ch <= 'z')
     {
        //shift character length of key
        ch = ch + key;
        //if shift passes z
        if(ch > 'z')
        {
          ch = ch - 'z' + 'a' - 1;
        }
        plaintext[i] = ch;
      }
    //if uppercase
    else if (ch >= 'A' && ch <= 'Z')
       {
          //shift character length of key
          ch = ch + key;
          //if shift passes Z
          if(ch > 'Z')
          {
             ch = ch - 'Z' + 'A' - 1;
          }
      plaintext[i] = ch;
      }
   }
  printf("Here is the encrypted message: %s", plaintext);
}

//Decrypt method to take string of characters and shift each character
//using the key provided by the user, neccessary parameters plaintext
// and key.
void Decrypt(char plaintext[1000], int key)
{
  int i, ch;
  //for the length of the string entered by the user
  for(i = 0; plaintext[i] != '\0'; i++)
  {
     ch = plaintext[i];
     //if lowercase
     if(ch >= 'a' && ch <= 'z')
     {
        ch = ch - key;
        //if shift back passes a
        if(ch < 'a')
        {
          ch = ch + 'z' - 'a' + 1;
        }
      plaintext[i] = ch;
      }
    //if uppercase
    else if (ch >= 'A' && ch <= 'Z')
       {
          ch = ch - key;
          //if shift passes A
          if(ch < 'A')
          {
             ch = ch + 'Z' - 'A' + 1;
          }
      plaintext[i] = ch;
      }
   }
  printf("Here is the decrypted message: %s\n", plaintext);
}

int main()
{
  char plaintext[1000];
  int key;

  //Ask user for message and scan into variable plaintext
  printf("Time to decrypt!\n");
  printf("Enter a message you'd like to encrypt (No Spaces): \n");
  scanf("%s", plaintext);
  //Ask user for key and scan into variable key
  printf("Now, enter the key: \n");
  scanf("%d", &key);

  Encrypt(plaintext, key);

  //Ask user for message and scan into variable plaintext
  printf("\n----------------------------------------\n");
  printf("Time to decrypt!\n");
  printf("Enter a message to decrypt (No Spaces): \n");
  scanf("%s", plaintext);
  //Ask user for key and scan into variable key
  printf("Now, enter the key: \n");
  scanf("%d", &key);

  Decrypt(plaintext, key);

  return 0;
}
//end program
