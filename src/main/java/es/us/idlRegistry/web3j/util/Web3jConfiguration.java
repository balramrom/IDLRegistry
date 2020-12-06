package es.us.idlRegistry.web3j.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static es.us.idlRegistry.web3j.util.FileManager.*;


public class Web3jConfiguration {

    public static void initConfigurationFile() {
        String filePath = "src/main/resources/web3j.properties";
        createFileIfNotExists(filePath);
        BufferedReader br = openReader(filePath);

        try {
            if(br.readLine()==null) {
                BufferedWriter bw = openWriter(filePath);

                bw.append("password=pass1234\n");
                bw.append("source=/home/balta/.ethereum/testnet/keystore/UTC--2020-10-24T16-09-39.463233000Z--cec80e98667ede36d473612e6e084764adbe4144.json\n");
                bw.append("network=https://rinkeby.infura.io/<your-token>\n");
                bw.append("account.address=0x98655b7f3e47518ea3dd6a5f4def4b261759dee8\n");
                bw.append("\n");

                bw.flush();
                bw.close();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
