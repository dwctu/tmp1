package com.google.common.base;

import com.broadcom.bt.util.io.IOUtils;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class CharMatcher implements Predicate<Character> {
    private static final int DISTINCT_CHARS = 65536;

    public static final class And extends CharMatcher {
        public final CharMatcher first;
        public final CharMatcher second;

        public And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.first.matches(c) && this.second.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.first.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.second.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.first + ", " + this.second + ")";
        }
    }

    public static final class Any extends NamedFastMatcher {
        public static final Any INSTANCE = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }
    }

    public static final class AnyOf extends CharMatcher {
        private final char[] chars;

        public AnyOf(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.chars = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Arrays.binarySearch(this.chars, c) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            for (char c : this.chars) {
                bitSet.set(c);
            }
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.chars) {
                sb.append(CharMatcher.showCharacter(c));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class Ascii extends NamedFastMatcher {
        public static final Ascii INSTANCE = new Ascii();

        public Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 127;
        }
    }

    @GwtIncompatible
    public static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet table;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.table.get(c);
        }

        @Override // com.google.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            bitSet.or(this.table);
        }

        private BitSetMatcher(BitSet bitSet, String str) {
            super(str);
            this.table = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    public static final class BreakingWhitespace extends CharMatcher {
        public static final CharMatcher INSTANCE = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            if (c != ' ' && c != 133 && c != 5760) {
                if (c == 8199) {
                    return false;
                }
                if (c != 8287 && c != 12288 && c != 8232 && c != 8233) {
                    switch (c) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c >= 8192 && c <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class Digit extends RangesMatcher {
        public static final Digit INSTANCE = new Digit();
        private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        private Digit() {
            super("CharMatcher.digit()", zeroes(), nines());
        }

        private static char[] nines() {
            char[] cArr = new char[37];
            for (int i = 0; i < 37; i++) {
                cArr[i] = (char) (ZEROES.charAt(i) + '\t');
            }
            return cArr;
        }

        private static char[] zeroes() {
            return ZEROES.toCharArray();
        }
    }

    public static abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> predicate;

        public ForPredicate(Predicate<? super Character> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.predicate.apply(Character.valueOf(c));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.predicate + ")";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public boolean apply(Character ch) {
            return this.predicate.apply(Preconditions.checkNotNull(ch));
        }
    }

    public static final class InRange extends FastMatcher {
        private final char endInclusive;
        private final char startInclusive;

        public InRange(char c, char c2) {
            Preconditions.checkArgument(c2 >= c);
            this.startInclusive = c;
            this.endInclusive = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.startInclusive <= c && c <= this.endInclusive;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            bitSet.set(this.startInclusive, this.endInclusive + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.startInclusive) + "', '" + CharMatcher.showCharacter(this.endInclusive) + "')";
        }
    }

    public static final class Invisible extends RangesMatcher {
        public static final Invisible INSTANCE = new Invisible();
        private static final String RANGE_ENDS = "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";
        private static final String RANGE_STARTS = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        private Invisible() {
            super("CharMatcher.invisible()", RANGE_STARTS.toCharArray(), RANGE_ENDS.toCharArray());
        }
    }

    public static final class Is extends FastMatcher {
        private final char match;

        public Is(char c) {
            this.match = c;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? this : CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.match;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? charMatcher : super.or(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.match, c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            bitSet.set(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    public static final class IsEither extends FastMatcher {
        private final char match1;
        private final char match2;

        public IsEither(char c, char c2) {
            this.match1 = c;
            this.match2 = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.match1 || c == this.match2;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            bitSet.set(this.match1);
            bitSet.set(this.match2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
        }
    }

    public static final class IsNot extends FastMatcher {
        private final char match;

        public IsNot(char c) {
            this.match = c;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? super.and(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c != this.match;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? CharMatcher.any() : this;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            bitSet.set(0, this.match);
            bitSet.set(this.match + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    public static final class JavaDigit extends CharMatcher {
        public static final JavaDigit INSTANCE = new JavaDigit();

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class JavaIsoControl extends NamedFastMatcher {
        public static final JavaIsoControl INSTANCE = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    public static final class JavaLetter extends CharMatcher {
        public static final JavaLetter INSTANCE = new JavaLetter();

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class JavaLetterOrDigit extends CharMatcher {
        public static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class JavaLowerCase extends CharMatcher {
        public static final JavaLowerCase INSTANCE = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class JavaUpperCase extends CharMatcher {
        public static final JavaUpperCase INSTANCE = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        public NamedFastMatcher(String str) {
            this.description = (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.description;
        }
    }

    public static class Negated extends CharMatcher {
        public final CharMatcher original;

        public Negated(CharMatcher charMatcher) {
            this.original = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.original.countIn(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return !this.original.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.original.matchesNoneOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.original.matchesAllOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.original;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.original.setBits(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.original + ".negate()";
        }
    }

    public static class NegatedFastMatcher extends Negated {
        public NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class None extends NamedFastMatcher {
        public static final None INSTANCE = new None();

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }
    }

    public static final class Or extends CharMatcher {
        public final CharMatcher first;
        public final CharMatcher second;

        public Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.first.matches(c) || this.second.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            this.first.setBits(bitSet);
            this.second.setBits(bitSet);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.first + ", " + this.second + ")";
        }
    }

    public static class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        public RangesMatcher(String str, char[] cArr, char[] cArr2) {
            this.description = str;
            this.rangeStarts = cArr;
            this.rangeEnds = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                Preconditions.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            int iBinarySearch = Arrays.binarySearch(this.rangeStarts, c);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i = (~iBinarySearch) - 1;
            return i >= 0 && c <= this.rangeEnds[i];
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.description;
        }
    }

    public static final class SingleWidth extends RangesMatcher {
        public static final SingleWidth INSTANCE = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    @VisibleForTesting
    public static final class Whitespace extends NamedFastMatcher {
        public static final int MULTIPLIER = 1682554634;
        public static final String TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";
        public static final int SHIFT = Integer.numberOfLeadingZeros(31);
        public static final Whitespace INSTANCE = new Whitespace();

        public Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return TABLE.charAt((MULTIPLIER * c) >>> SHIFT) == c;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet bitSet) {
            for (int i = 0; i < 32; i++) {
                bitSet.set(TABLE.charAt(i));
            }
        }
    }

    public static CharMatcher any() {
        return Any.INSTANCE;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new AnyOf(charSequence) : isEither(charSequence.charAt(0), charSequence.charAt(1)) : is(charSequence.charAt(0)) : none();
    }

    public static CharMatcher ascii() {
        return Ascii.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.INSTANCE;
    }

    @Deprecated
    public static CharMatcher digit() {
        return Digit.INSTANCE;
    }

    private String finishCollapseFrom(CharSequence charSequence, int i, int i2, char c, StringBuilder sb, boolean z) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (!matches(cCharAt)) {
                sb.append(cCharAt);
                z = false;
            } else if (!z) {
                sb.append(c);
                z = true;
            }
            i++;
        }
        return sb.toString();
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new ForPredicate(predicate);
    }

    public static CharMatcher inRange(char c, char c2) {
        return new InRange(c, c2);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return Invisible.INSTANCE;
    }

    public static CharMatcher is(char c) {
        return new Is(c);
    }

    private static IsEither isEither(char c, char c2) {
        return new IsEither(c, c2);
    }

    public static CharMatcher isNot(char c) {
        return new IsNot(c);
    }

    @GwtIncompatible
    private static boolean isSmall(int i, int i2) {
        return i <= 1023 && i2 > (i * 4) * 16;
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return JavaDigit.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return JavaLetter.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.INSTANCE;
    }

    public static CharMatcher none() {
        return None.INSTANCE;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    @GwtIncompatible
    private static CharMatcher precomputedPositive(int i, BitSet bitSet, String str) {
        if (i == 0) {
            return none();
        }
        if (i == 1) {
            return is((char) bitSet.nextSetBit(0));
        }
        if (i != 2) {
            return isSmall(i, bitSet.length()) ? SmallCharMatcher.from(bitSet, str) : new BitSetMatcher(bitSet, str);
        }
        char cNextSetBit = (char) bitSet.nextSetBit(0);
        return isEither(cNextSetBit, (char) bitSet.nextSetBit(cNextSetBit + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String showCharacter(char c) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return SingleWidth.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return Whitespace.INSTANCE;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

    public String collapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (matches(cCharAt)) {
                if (cCharAt != c || (i != length - 1 && matches(charSequence.charAt(i + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                    sb.append(c);
                    return finishCollapseFrom(charSequence, i + 1, length, c, sb, true);
                }
                i++;
            }
            i++;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (matches(charSequence.charAt(i2))) {
                i++;
            }
        }
        return i;
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public CharMatcher negate() {
        return new Negated(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    @GwtIncompatible
    public CharMatcher precomputedInternal() {
        String strSubstring;
        BitSet bitSet = new BitSet();
        setBits(bitSet);
        int iCardinality = bitSet.cardinality();
        if (iCardinality * 2 <= 65536) {
            return precomputedPositive(iCardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i = 65536 - iCardinality;
        final String string = toString();
        if (string.endsWith(".negate()")) {
            strSubstring = string.substring(0, string.length() - 9);
        } else {
            strSubstring = string + ".negate()";
        }
        return new NegatedFastMatcher(precomputedPositive(i, bitSet, strSubstring)) { // from class: com.google.common.base.CharMatcher.1
            @Override // com.google.common.base.CharMatcher.Negated, com.google.common.base.CharMatcher
            public String toString() {
                return string;
            }
        };
    }

    public String removeFrom(CharSequence charSequence) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i = 1;
        while (true) {
            iIndexIn++;
            while (iIndexIn != charArray.length) {
                if (matches(charArray[iIndexIn])) {
                    break;
                }
                charArray[iIndexIn - i] = charArray[iIndexIn];
                iIndexIn++;
            }
            return new String(charArray, 0, iIndexIn - i);
            i++;
        }
    }

    public String replaceFrom(CharSequence charSequence, char c) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iIndexIn] = c;
        while (true) {
            iIndexIn++;
            if (iIndexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[iIndexIn])) {
                charArray[iIndexIn] = c;
            }
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    @GwtIncompatible
    public void setBits(BitSet bitSet) {
        for (int i = 65535; i >= 0; i--) {
            if (matches((char) i)) {
                bitSet.set(i);
            }
        }
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = length - 1;
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = i;
        while (i3 > i2 && matches(charSequence.charAt(i3))) {
            i3--;
        }
        if (i2 == 0 && i3 == i) {
            return collapseFrom(charSequence, c);
        }
        int i4 = i3 + 1;
        return finishCollapseFrom(charSequence, i2, i4, c, new StringBuilder(i4 - i2), false);
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        while (i < length) {
            if (matches(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) string, i, iIndexIn);
            sb.append(charSequence2);
            i = iIndexIn + 1;
            iIndexIn = indexIn(string, i);
        } while (iIndexIn != -1);
        sb.append((CharSequence) string, i, length2);
        return sb.toString();
    }
}
