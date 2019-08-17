# INWISENG

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.1.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


Custom commands:
*****************
Checking npm version: npm -v / npm --version
Checking ng version: ng --version


Running the application: ng serve -o / ng serve --open




Adding NG Material
ng add @angular/material (use any themes, hammerJS, Animations)
ng add @angular/cdk (the above command will install CDK also, but try if needed explicitly)
ng add @angular/animations (Try if needed)

ng generate @angular/material:nav <component-name>
ng generate @angular/material:nav nav


References:
https://material.io
https://material.angular.io/guide/schematics


Tasks:
*******

UI:
****
1. Implement web layout with toolbar as header, side navigation and footer - Partly DONE
2. Load main content by clicking navigation
3. Enable Angular routing to interact with WebService
4. Implement invoice as PDF and printing options
5. Implement Login screen and load the UI based on the logged-in user previlege


Technical Improvisations:
**************************
1. WebService to have dual data base writing capability (Also to read from NoSQL on use case basis. For instance, have the reports module to use NoSQL; port module by module)
2. Scalability:
	- Break the monoloithic service to micro-services
	- Containerize all the layer in the application (UI, micro-services and DB)