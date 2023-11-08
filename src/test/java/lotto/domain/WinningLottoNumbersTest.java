package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class WinningLottoNumbersTest {

  @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void createWinningLottoNumbersByOverSize() {
    List<Integer> invalidNumbers = Arrays.asList(10, 20, 30, 40, 15, 25, 16);
    int validBonusNumber = 5;
    assertThrows(IllegalArgumentException.class,
        () -> new WinningLottoNumbers(invalidNumbers, validBonusNumber));
  }

  @DisplayName("로또 번호가 중복되면 에러가 발생한다.")
  @Test
  void invalidWinningLottoNumbers_Duplicate() {
    List<Integer> invalidNumbers = Arrays.asList(10, 20, 30, 40, 20, 25);
    int invalidBonusNumber = 5;

    assertThrows(IllegalArgumentException.class,
        () -> new WinningLottoNumbers(invalidNumbers, invalidBonusNumber));
  }

  @DisplayName("로또 번호의 개수가 6개 이하면 에러가 발생한다.")
  @Test
  void invalidWinningLottoNumbers_WrongSize() {
    List<Integer> invalidNumbers = Arrays.asList(10, 20, 30, 40, 15);
    int invalidBonusNumber = 5;

    assertThrows(IllegalArgumentException.class,
        () -> new WinningLottoNumbers(invalidNumbers, invalidBonusNumber));
  }

  @DisplayName("로또 번호와 보너스 번호가 중복되면 에러가 발생한다.")
  @Test
  void invalidWinningLottoNumbers_BonusDuplicate() {
    List<Integer> invalidNumbers = Arrays.asList(10, 20, 30, 40, 15, 25);
    int invalidBonusNumber = 25;

    assertThrows(IllegalArgumentException.class,
        () -> new WinningLottoNumbers(invalidNumbers, invalidBonusNumber));
  }
}
