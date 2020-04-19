import java.util.Arrays;

public class CircularBuffer {
  int size_;
  int start_;
  int len_;
  byte[] buf_;

  public CircularBuffer(int size) {
    this.size_ = size;
    this.start_ = 0;
    this.len_ = 0;
    this.buf_ = new byte[size];
  }

  public int read(int len, byte[] buf_out) {
    int read_len = Math.min(len, this.len_);
  
    int first_len = Math.min(read_len, this.size_ - this.start_);
    System.arraycopy(this.buf_, this.start_, buf_out, 0, first_len);    

    System.arraycopy(this.buf_, 0, buf_out, first_len, read_len-first_len);
    this.start_ = (this.start_ + read_len) % this.size_;
    this.len_ -= read_len;
  
    return read_len;
  }
  
  public int write(int len, byte[] buf_in) {
    int write_len = Math.min(len, this.size_ - this.len_);
  
    int end = this.start_ + this.len_;
    int first_len = Math.min(write_len, this.size_ - end); 
    System.arraycopy(buf_in, 0, this.buf_, end, first_len);
  
    System.arraycopy(buf_in, first_len, this.buf_, 0, write_len-first_len);
    this.len_ += write_len;
    
    return write_len;
  }

  public static void main(String[] args) {
    int ret;
    CircularBuffer cb = new CircularBuffer(20);
    byte[] buf_in = {1,3,6,7,23,27,34,38,44,48,52,57,61,68,70,75,88,92,93,99};
    byte[] buf_golden = {7,23,27,34,38,44,48,52,57,61,68,70,75,88,92,93,99,1,3,6};
    byte[] buf_out = new byte[20];
  
    ret = cb.write(5, buf_in);
    System.out.println("write returns " + ret);
    ret = cb.read(3, buf_out);
    System.out.println("read returns " + ret);
  
    for (byte b : buf_out)
      System.out.print(b + " ");
    System.out.println(); 
  
    cb.write(15, Arrays.copyOfRange(buf_in, 5, 20));
    cb.write(3, buf_in);
    cb.read(20, buf_out);
    
    for (byte b : buf_out)
      System.out.print(b + " ");
    System.out.println(); 
  }
}
