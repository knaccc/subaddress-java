``` java
String mainAddress = "43amHgM9cDHhJY8tAujYi4MisCx4dvNQB5xVYbRLqPYLbVmH5qHcUgsjgsdoSdLK3TgRaBd68bCLaRcK8VakCUAJLGjz42G";
WalletAddress walletAddress = new WalletAddress(mainAddress);

Scalar privateViewKey = new Scalar("7b37d8922245a07244fd31855d1e705a590a9bd2881825f0542ad99cdaba090a");

System.out.println("subaddress for account index 0, subaddress index 1: " + getSubaddressBase58(privateViewKey, hexToBytes(walletAddress.getPublicSpendKeyHex()), 0, 1));
```