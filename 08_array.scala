// =====================================================================
// ⚡ Difference Between List and Array in Scala
// =====================================================================
//
// LIST
// ----
// ✔ Immutable  (cannot change original list)
// ✔ Size is NOT fixed
// ✔ Best for functional programming
// ✔ Safer in multi-threading because no accidental changes
// ❌ Slower for indexing compared to Array
//
// Example:
// val nums = List(1, 2, 3)
// val newList = nums :+ 4   // new list created, original unchanged
//
//
// ARRAY
// ------
// ✔ Mutable  (values can be updated in place)
// ✔ Fixed size
// ✔ Very fast for indexing (arr(0), arr(1), ...)
// ❌ Not functional style
//
// Example:
// val arr = Array(1, 2, 3)
// arr(0) = 100   // modifies existing array
//
//
// 🔥 Quick Comparison
// ---------------------------------------------------------------------
// Feature               List                 Array
// ---------------------------------------------------------------------
// Mutability          ❌ Immutable          ✔ Mutable
// Size                Dynamic               Fixed
// Thread Safety       High                  Low
// Speed (indexing)    Slower                Very fast
// Functional Style    ✔ Yes                 ❌ No
//
// 🔥 When to use which?
// ---------------------------------------------------------------------
// Use List when -> you want safety, immutability, functional style
// Use Array when -> you need very fast indexing / performance
//
// ❗Outputs are similar visually, but behaviour is different
// List  returns: List(1, 2, 3)
// Array returns: Array(1, 2, 3) or "1, 2, 3" using mkString
//
// In automation, List is preferred for:
//     API data, CSV/text rows, function transformations
//
// In performance-critical code, Array is preferred for:
//     loops, math operations, byte processing, indexing
// =====================================================================
