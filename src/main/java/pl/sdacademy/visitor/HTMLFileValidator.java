package pl.sdacademy.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HTMLFileValidator implements Visitor {

  @Override
  public void validateFile(final HTML4File html4File) {
    log.info("Validating HTML 4 schema with https://validator.w3.org/#validate_by_uri+with_options");
  }

  @Override
  public void validateFile(final HTML5File html5File) {
    log.info("Validating HTML 5 schema with https://validator.w3.org/#validate_by_uri+with_options");
  }

  @Override
  public void validateFile(final XHTMLFile xhtmlFile) {
    log.info("Validating XHTML schema with https://validator.w3.org/#validate_by_uri+with_options");
  }
}
