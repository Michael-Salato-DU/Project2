import { AppPage } from './app.po';
import { browser, logging } from 'protractor';
import { element, by } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    
    expect(browser.getTitle()).toEqual("BADS Hotel");
  });
  
  // it('should get register', () => {
  //   element(by.id('mainPageRegister')).click();
  //   element(by.id('first_name')).sendKeys('firstname');
  //   element(by.id('last_name')).sendKeys('lastname');
  //   element(by.id('email')).sendKeys('email@email.email');
  //   element(by.id('phone')).sendKeys('555-555-test');
  //   element(by.id('Address')).sendKeys('Address');
  //   element(by.id('rusername')).sendKeys('rusername');
  //   element(by.id('rpassword')).sendKeys('rpassword');
  //   element(by.id('modalRegister')).click();
  // });

  it('should login successfully', () => {
    element(by.id('mainPageLogin')).click();
    element(by.name('uname')).sendKeys('test1');
    element(by.name('psw')).sendKeys('test1');
    element(by.id('modalLogin')).click();
    expect(element(by.id('showMyReservations'))).toBeTruthy();

  });

  it('should be able to see past reservations', () => {
    expect(element(by.id('showMyReservations'))).toBeTruthy();
  });

  it('should search for a date', ()=> {
    element(by.id('arrivalDate')).sendKeys('03133019');
    element(by.id('departureDate')).sendKeys('03153019');
    element(by.id('seeAvailableRoomsBtn')).click();

    expect(element(by.id('5'))).toBeTruthy();

  });

  it('should be able to checkout after selecting a date', ()=> {
    element(by.id('5')).click();
    
    expect(by.id('reserveRoomBtn')).toBeTruthy();
  });


  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    }));
  });
});
