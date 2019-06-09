package gpb.service;

import gpb.web.dto.Payment;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;

public class PaymentSaveService {

    public static void save(String paymentsFileName, List<Payment> paymentList) throws IOException {
        try (
                RandomAccessFile stream = new RandomAccessFile(paymentsFileName, "rw");
                FileChannel channel = stream.getChannel();
                FileLock lock = channel.tryLock();
        ) {
            stream.setLength(0);
            for (Payment payment : paymentList) {
                stream.write((payment.toString() + "\r\n").getBytes());
            }
            lock.release();
        }
    }

}
