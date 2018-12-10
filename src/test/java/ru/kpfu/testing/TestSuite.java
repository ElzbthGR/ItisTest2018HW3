package ru.kpfu.testing;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTests.class, BoardTests.class})
public class TestSuite {
}
