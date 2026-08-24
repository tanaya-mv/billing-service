# billing-service (demo repo for Slides 17–19)

A deliberately tiny Java/Maven service that exists only to make the
CI/CD demo real: a `build` -> `test` -> `secret-scan` pipeline you can
run locally with `act`, then break in two specific ways.


## Demo 1 — hardcoded secret (Slide 18)

1. Add a fake credential to `src/main/resources/application.properties`:
   ```
   aws.secret.key=AKIAABCDEFGHIJKLMNOP
   ```
2. Show it still compiles and tests still pass:
   ```bash
   mvn clean compile && mvn test
   ```
3. Run the scan and show it catches it:
   ```bash
   gitleaks detect --source . -v
   ```
4. Restore: `git reset --hard clean-start`

## Demo 2 — failing test (Slide 17)

1. In `InvoiceCalculatorTest.java`, change the expected value
   (e.g. `110.0` -> `999.0`).
2. Run the pipeline locally:
   ```bash
   act -j test
   ```
   It fails at the `test` job and never reaches `secret-scan` — the
   fail-fast / stage-order point from Slide 19.
3. Restore: `git reset --hard clean-start`
