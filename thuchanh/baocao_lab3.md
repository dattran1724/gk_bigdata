
## 1. Quá trình thực hiện
Tôi đã hoàn thành mã nguồn cho 5 phần của bài thực hành:
1. **Phần 1**: Tạo các hàm `printEvenNumbers` và `printNumbersDivisibleByThree`.
2. **Phần 2**: Tạo các class thực thi `Function<Integer, Boolean>` như `IsEven` và hàm `printNumbers`.
3. **Phần 3 & 4**: Sử dụng biểu thức Lambda và tham số hóa để tạo các bộ lọc động theo `base`.
4. **Phần 5**: Triển khai *Function Composition* với 2 hàm `combineWithAnd` và `combineWithOr` để nối các bộ lọc lại với nhau xử lý trường hợp nhiều cơ số.
5. **Phần 6**: Cấu hình file `pom.xml`, viết script `run.sh` để biên dịch.

## 2. Kết quả chạy thử (Test Run)
Chương trình đã được build thành công (`BUILD SUCCESS`). Script `run.sh` đã tự động chạy 3 câu lệnh kiểm thử như yêu cầu của bài. Dưới đây là kết quả thực tế thu được từ Terminal:

### Test Case 1: `java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 5`
In ra các số chia hết cho 5 trong khoảng `[3, 20]`
```text
Printing numbers in the range [3,20]
5
10
15
20
```

### Test Case 2: `java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 3,5`
In ra các số chia hết cho 3 **VÀ** 5 (phép AND `,`) trong khoảng `[3, 20]`
```text
Printing numbers in the range [3,20]
15
```

### Test Case 3: `java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 3v5`
In ra các số chia hết cho 3 **HOẶC** 5 (phép OR `v`) trong khoảng `[3, 20]`
```text
Printing numbers in the range [3,20]
3
5
6
9
10
12
15
18
20
```
