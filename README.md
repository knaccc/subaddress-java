``` java
String mainAddress = "43amHgM9cDHhJY8tAujYi4MisCx4dvNQB5xVYbRLqPYLbVmH5qHcUgsjgsdoSdLK3TgRaBd68bCLaRcK8VakCUAJLGjz42G";
String privateViewKeyHex = "7b37d8922245a07244fd31855d1e705a590a9bd2881825f0542ad99cdaba090a";

WalletAddress walletAddress = new WalletAddress(mainAddress);

System.out.println("subaddress for account index 0, subaddress index 1: "
  + walletAddress.getSubaddressBase58(privateViewKeyHex, 0, 1));
```