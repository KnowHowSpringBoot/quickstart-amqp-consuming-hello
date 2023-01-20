package org.ujar.bs.msg.amqp.consuming.hello.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.DependencyRules.NO_CLASSES_SHOULD_DEPEND_UPPER_PACKAGES;
import static com.tngtech.archunit.library.GeneralCodingRules.ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.CompositeArchRule;
import org.slf4j.Logger;

@AnalyzeClasses(packages = "org.ujar.bs.msg.amqp.consuming.hello")
class CodingRulesTest {
  @ArchTest
  private final ArchRule noClassesShouldAccessStandardStreams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
  @ArchTest
  private final ArchRule noGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
  @ArchTest
  private final ArchRule noJavaUtilLogging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
  @ArchTest
  private final ArchRule loggersShouldBePrivateStaticFinal =
      fields().that().haveRawType(Logger.class)
          .should().bePrivate()
          .andShould().beStatic()
          .andShould().beFinal()
          .because("we agreed on this convention");
  @ArchTest
  private final ArchRule noJodatime = NO_CLASSES_SHOULD_USE_JODATIME;
  @ArchTest
  private final ArchRule noFieldInjection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
  @ArchTest
  private final ArchRule noClassesShouldAccessStandardStreamsOrThrowGenericExceptions =
      CompositeArchRule.of(NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
          .and(NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS);
  @ArchTest
  private final ArchTests namingConventionRules = ArchTests.in(NamingConventionTest.class);
  @ArchTest
  private final ArchRule noAccessesToUpperPackage = NO_CLASSES_SHOULD_DEPEND_UPPER_PACKAGES;

  @ArchTest
  private void noAccessToStandardStreamsAsMethod(JavaClasses classes) {
    noClasses().should(ACCESS_STANDARD_STREAMS).check(classes);
  }
}
