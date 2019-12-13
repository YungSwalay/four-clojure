# four-clojure

This app allows easy testing of solutions to the problems on the 4clojure.com

## Usage

I still haven't used it much at CLI directly, but from the repl you can use -main
as such:

	=> (-main [p & args])

where `p` is 4clojure problem number and args are the args that you would like to test.
In general, `__` in the 4clojure problems can be replaced with `-main p` to produce
a true result for the unit tests.

## Examples

Problem #62 (iterate)
    => (= (take 100 (-main 62 inc 0)) (take 100 (range)))
    ;; true

Problem #55 (count-occurrences)
    => (= (-main 55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
    ;; true

## License

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
