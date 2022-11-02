package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] map;
        int XrowBingo, OrowBingo; // X, O 가로 빙고
        int XcolBingo, OcolBingo; //X, O 세로 빙고
        int XcrossBingo, OcrossBingo; //X, O 대각선 빙고

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            // 가로, 세로, 대각선을 검사하여 빙고가 있는지 확인
            // 빙고가 있다면 같은 라인에 여러 빙고가 있으면 안됨!
            // X와 O의 개수가 같다면 O가 이겨야 한다 (X가 먼저 시작하니까)
            // X의 개수가 더 크다면 X가 이겨야 한다 (X가 먼저 시작하니까)
            // 빙고가 하나도 없는데 게임을 끝내면 안된다

            // 빙고 개수 초기화
            XrowBingo = 0;
            OrowBingo = 0;
            XcolBingo = 0;
            OcolBingo = 0;
            XcrossBingo = 0;
            OcrossBingo = 0;

            map = new char[3][3];
            int Xcount = 0; // X 개수
            int Ocount = 0; // O 개수
            int index = 0;
            // 빙고판 초기화 및 X와 O의 개수 판별
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = str.charAt(index);
                    index++;

                    if (map[i][j] == 'O') {
                        Ocount++;
                    } else if (map[i][j] == 'X') {
                        Xcount++;
                    }
                }
            }

            // X와 O의 개수 차이가 2이상이거나 O의 개수가 더 크면 INVALID
            if (Math.abs(Xcount - Ocount) >= 2 || Ocount > Xcount) {
                sb.append("invalid");
                sb.append('\n');
                continue;
            }

            // 가로, 세로 빙고 검사
            for (int i = 0; i < 3; i++) {
                int rowX = 0;
                int rowO = 0;
                int colX = 0;
                int colO = 0;

                for (int j = 0; j < 3; j++) {
                    // 가로 검사
                    if (map[i][j] == 'X') {
                        rowX++;
                    } else if (map[i][j] == 'O') {
                        rowO++;
                    }

                    // 세로 검사
                    if (map[j][i] == 'X') {
                        colX++;
                    } else if (map[j][i] == 'X') {
                        colO++;
                    }

                    // 빙고 검사
                    if (rowX == 3) {
                        XrowBingo++;
                    } else if (rowO == 3) {
                        OrowBingo++;
                    } else if (colX == 3) {
                        XcolBingo++;
                    } else if (colO == 3) {
                        OcolBingo++;
                    }
                }
            }

            // 같은 라인에 빙고가 여러 개인 경우 INVALID
            if (XrowBingo > 1 || OrowBingo > 1 || XcolBingo > 1 || OcolBingo > 1) {
                sb.append("invalid\n");
                continue;
            }

            // 왼쪽 하향 대각선 검사
            int crossX = 0;
            int crossO = 0;
            for (int i = 0; i < 3; i++) {
                if (map[i][i] == 'X') {
                    crossX++;
                } else if (map[i][i] == 'O') {
                    crossO++;
                }

                // 빙고 검사
                if (crossX == 3) {
                    XcrossBingo++;
                } else if (crossO == 3) {
                    OcrossBingo++;
                }
            }

            // 오른쪽 상향 대각선 검사
            crossO = 0;
            crossX = 0;
            for (int i = 0; i < 3; i++) {
                if (map[i][2 - i] == 'X') {
                    crossX++;
                } else if (map[i][2 - i] == 'O') {
                    crossO++;
                }

                // 빙고 검사
                if (crossX == 3) {
                    XcrossBingo++;
                } else if (crossO == 3) {
                    OcrossBingo++;
                }
            }

            // X == O 이면 O가 이겨야 한다
            if (Xcount == Ocount) {
                if (XrowBingo > 0 || XcolBingo > 0 || XcrossBingo > 0) {
                    sb.append("invalid\n");
                    continue;
                }
            }

            // X>O 이면 X가 이겨야 한다
            if (Xcount > Ocount) {
                if (OrowBingo > 0 || OcolBingo > 0 || OcrossBingo > 0) {
                    sb.append("invalid\n");
                    continue;
                }
            }

            // X와 O의 합이 9개인 경우 - VALID
            if (Xcount + Ocount == 9) {
                sb.append("valid\n");
                continue;
            }

            // 빙고가 하나도 없는 경우 - INVALID
            if (XrowBingo + OrowBingo + XcolBingo + OcolBingo + XcrossBingo + OcrossBingo == 0) {
                sb.append("invalid\n");
                continue;
            }

            // 모든 경우를 통과한 경우 VALID
            sb.append("valid\n");
        } //while 반복문
        System.out.println(sb);
    }
}
