### 수반행렬이란?

**수반행렬**(Adjugate Matrix 또는 Adjoint Matrix)은 정방행렬(square matrix)에서 정의되며, 역행렬을 구할 때 중요한 역할을 합니다.

수반행렬은 주어진 행렬의 **여인수(cofactor)**들로 구성된 행렬의 전치(transpose) 행렬입니다.

---

### 수반행렬 계산 방법
1. **여인수(Cofactor) 계산**:
    - 행렬의 각 원소에 대해, 해당 원소를 포함하지 않는 소행렬(minor)의 행렬식을 계산하여 여인수를 구합니다.
    - 여인수는 행렬식에 위치에 따라 부호를 적용한 값입니다:
      \[
      C_{ij} = (-1)^{i+j} \cdot \text{det}(M_{ij})
      \]
      여기서 \( M_{ij} \)는 \( i \)-번째 행과 \( j \)-번째 열을 제외한 소행렬입니다.

2. **여인수 행렬(Cofactor Matrix) 구성**:
    - 구한 여인수들을 원래 행렬의 각 위치에 대응하도록 배치하여 여인수 행렬을 만듭니다.

3. **여인수 행렬의 전치(Transpose)**:
    - 여인수 행렬을 전치하여 수반행렬을 얻습니다.

---

### 수반행렬의 정의 수식
주어진 행렬 \( A \)에 대해, 수반행렬 \( \text{adj}(A) \)는 다음과 같이 정의됩니다:
\[
\text{adj}(A) = \text{transpose}(\text{Cofactor}(A))
\]

---

### 예제: \( 3 \times 3 \) 행렬의 수반행렬
주어진 행렬 \( A = \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix} \):

1. **여인수 계산**:
    - \( C_{11} = \text{det} \begin{bmatrix} e & f \\ h & i \end{bmatrix} = ei - fh \)
    - \( C_{12} = -\text{det} \begin{bmatrix} d & f \\ g & i \end{bmatrix} = -(di - fg) \)
    - \( C_{13} = \text{det} \begin{bmatrix} d & e \\ g & h \end{bmatrix} = dh - eg \)
    - 나머지 여인수들도 같은 방식으로 계산.

2. **여인수 행렬 구성**:
   \[
   \text{Cofactor}(A) =
   \begin{bmatrix}
   ei - fh & -(di - fg) & dh - eg \\
   -(bi - ch) & ai - cg & -(ah - bg) \\
   bf - ce & -(af - cd) & ae - bd
   \end{bmatrix}
   \]

3. **전치 행렬**:
   여인수 행렬을 전치(transpose)하면 수반행렬:
   \[
   \text{adj}(A) =
   \begin{bmatrix}
   ei - fh & -(bi - ch) & bf - ce \\
   -(di - fg) & ai - cg & -(af - cd) \\
   dh - eg & -(ah - bg) & ae - bd
   \end{bmatrix}
   \]

---

### 수반행렬의 활용
1. **역행렬 계산**:
    - 행렬 \( A \)의 역행렬은 수반행렬을 이용하여 다음과 같이 계산됩니다:
      \[
      A^{-1} = \frac{\text{adj}(A)}{\text{det}(A)}
      \]
      단, \( \text{det}(A) \neq 0 \)이어야 합니다.

2. **선형 시스템 해법**:
    - 크래머의 법칙(Cramer's Rule)에서 수반행렬을 사용하여 연립방정식의 해를 구할 수 있습니다.

3. **3D 그래픽스**:
    - 그래픽 변환에서 행렬의 역행렬을 구할 때, 특히 정사영(projection) 계산이나 텍스처 매핑(texture mapping)에 사용됩니다.

---

### 한 줄 요약
수반행렬은 행렬의 여인수를 이용해 구성된 전치 행렬로, 역행렬 계산과 선형 시스템 해법에서 중요한 역할을 합니다.