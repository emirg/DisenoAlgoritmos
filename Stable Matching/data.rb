n = ARGV.first.to_i

mens = n.times.map{|x| "Man#{x}"}
womens = n.times.map{|x| "Women#{x}"}

mens.each do |m|
  puts "#{m},#{womens.shuffle.join(",")}"
end
womens.each do |m|
  puts "#{m},#{mens.shuffle.join(",")}"
end
